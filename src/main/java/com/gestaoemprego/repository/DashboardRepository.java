package com.gestaoemprego.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DashboardRepository {

    @PersistenceContext
    private EntityManager em;

    // 1. Vagas por setor
    public List<Map<String, Object>> findVagasPorSector() {
        Query query = em.createNativeQuery("""
            SELECT e.sector AS name, COUNT(v.id_vaga) AS y
            FROM empresa e
            INNER JOIN vaga v ON e.id_empresa = v.id_empresa
            GROUP BY e.sector
            ORDER BY y DESC
        """);

        List<Object[]> results = query.getResultList();
        if (results == null || results.isEmpty()) {
            return List.of();
        }

        return results.stream()
                .map(r -> Map.of("name", r[0], "y", ((Number) r[1]).intValue()))
                .collect(Collectors.toList());
    }

    // 2. Candidatos por gênero
    public List<Map<String, Object>> findCandidatosPorGenero() {
        Query query = em.createNativeQuery("""
            SELECT 
                CASE 
                    WHEN genero = 'M' THEN 'Masculino'
                    WHEN genero = 'F' THEN 'Feminino'
                    ELSE 'Outro'
                END AS name,
                COUNT(*) AS y
            FROM candidato
            GROUP BY genero
        """);

        List<Object[]> results = query.getResultList();
        if (results == null || results.isEmpty()) {
            return List.of();
        }

        return results.stream()
                .map(r -> Map.of("name", r[0], "y", ((Number) r[1]).intValue()))
                .collect(Collectors.toList());
    }

    // 3. Vagas por mês nos últimos 6 meses 
    public List<Map<String, Object>> findVagasPorMesUltimos6Meses() {
        Query query = em.createNativeQuery("""
            SELECT 
                TO_CHAR(DATE_TRUNC('month', data_publicacao), 'TMMonth') AS name,
                COUNT(*) AS y
            FROM vaga
            WHERE data_publicacao >= DATE_TRUNC('month', CURRENT_DATE - INTERVAL '5 months')
              AND data_publicacao < DATE_TRUNC('month', CURRENT_DATE + INTERVAL '1 month')
            GROUP BY DATE_TRUNC('month', data_publicacao)
            ORDER BY DATE_TRUNC('month', data_publicacao)
        """);

        @SuppressWarnings("unchecked")
        List<Object[]> results = (List<Object[]>) query.getResultList();
        if (results == null || results.isEmpty()) {
            return List.of();
        }

        return results.stream()
                .map(r -> {
                    String month = ((String) r[0]).substring(0, 1).toUpperCase() +
                                   ((String) r[0]).substring(1).trim();
                    Integer count = ((Number) r[1]).intValue();
                    return Map.<String, Object>of("name", month, "y", count);
                })
                .collect(Collectors.toList());
    }

    // 4. Top 10 serviços com mais candidatos
public List<Map<String, Object>> findTop10ServicosComCandidatos() {
    Query query = em.createNativeQuery("""
        SELECT 
            s.nome_servico AS name, 
            COUNT(c.id_candidato) AS y
        FROM servico s
        JOIN candidatoServico cs ON s.id_servico = cs.id_servico
        JOIN candidato c ON cs.id_candidato = c.id_candidato
        GROUP BY s.nome_servico
        ORDER BY y DESC
        LIMIT 10
    """);

    @SuppressWarnings("unchecked")
    List<Object[]> results = query.getResultList();
    if (results == null || results.isEmpty()) {
        return List.of();
    }

    return results.stream()
            .map(r -> Map.of("name", r[0], "y", ((Number) r[1]).intValue()))
            .collect(Collectors.toList());
}




}
