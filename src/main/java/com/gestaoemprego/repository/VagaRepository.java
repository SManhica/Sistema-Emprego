package com.gestaoemprego.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class VagaRepository {

    @PersistenceContext
    private EntityManager em;

    // Vagas por Sector
    public List<Map<String, Object>> findVagasPorSector() {
        Query query = em.createNativeQuery("""
            SELECT e.sector AS name, COUNT(v.id_vaga) AS y
            FROM empresa e
            JOIN vaga v ON e.id_empresa = v.id_empresa
            GROUP BY e.sector
            ORDER BY y DESC
        """);

        List<Object[]> results = query.getResultList();
        if (results == null || results.isEmpty()) return List.of();

        return results.stream()
                .map(r -> Map.of("name", r[0], "y", ((Number) r[1]).intValue()))
                .collect(Collectors.toList());
    }

    // Vagas por Mês (últimos 6 meses)
    public List<Map<String, Object>> findVagasPorMesUltimos6Meses() {
        Query query = em.createNativeQuery("""
            SELECT TO_CHAR(DATE_TRUNC('month', data_publicacao), 'TMMonth') AS name,
                   COUNT(*) AS y
            FROM vaga
            WHERE data_publicacao >= DATE_TRUNC('month', CURRENT_DATE - INTERVAL '5 months')
              AND data_publicacao < DATE_TRUNC('month', CURRENT_DATE + INTERVAL '1 month')
            GROUP BY DATE_TRUNC('month', data_publicacao)
            ORDER BY DATE_TRUNC('month', data_publicacao)
        """);

        List<Object[]> results = query.getResultList();
        if (results == null || results.isEmpty()) return List.of();

        return results.stream()
                .map(r -> {
                    String month = ((String) r[0]).substring(0,1).toUpperCase() +
                                   ((String) r[0]).substring(1).trim();
                    Integer count = ((Number) r[1]).intValue();
                    return Map.<String, Object>of("name", month, "y", count);
                })
                .collect(Collectors.toList());
    }

    // Top Cidades com mais candidatos
    public List<Map<String, Object>> findTopCidadesComMaisCandidatos() {
        Query query = em.createNativeQuery("""
            SELECT c.nome AS name, COUNT(cd.id_candidato) AS y
            FROM endereco c
            JOIN vaga_localtrabalho vlt ON c.id_endereco = vlt.id_endereco
            JOIN vaga v ON vlt.id_vaga = v.id_vaga
            JOIN candidatoEndereco ce ON c.id_endereco = ce.id_endereco
            JOIN candidato cd ON ce.id_candidato = cd.id_candidato
            GROUP BY c.nome
            ORDER BY y DESC
            LIMIT 10
        """);

        List<Object[]> results = query.getResultList();
        if (results == null || results.isEmpty()) return List.of();

        return results.stream()
                .map(r -> Map.of("name", r[0], "y", ((Number) r[1]).intValue()))
                .collect(Collectors.toList());
    }

    // Candidatos por Gênero
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
        if (results == null || results.isEmpty()) return List.of();

        return results.stream()
                .map(r -> Map.of("name", r[0], "y", ((Number) r[1]).intValue()))
                .collect(Collectors.toList());
    }
}