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
        if (results == null || results.isEmpty()) {
            return List.of();
        }

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
        if (results == null || results.isEmpty()) {
            return List.of();
        }

        return results.stream()
                .map(r -> {
                    String month = ((String) r[0]).substring(0, 1).toUpperCase()
                            + ((String) r[0]).substring(1).trim();
                    Integer count = ((Number) r[1]).intValue();
                    return Map.<String, Object>of("name", month, "y", count);
                })
                .collect(Collectors.toList());
    }

    // Vagas por Estado
    public List<Map<String, Object>> findVagasByEstado() {
        Query query = em.createNativeQuery("""
            SELECT
    CASE 
        WHEN estado = 'Aberta' THEN 'Ativas'
        WHEN estado = 'Fechada' THEN 'Fechadas'
        WHEN estado = 'Pendente' THEN 'Pendente'
        ELSE 'Outras'
    END AS name,
    COUNT(*) AS y
FROM vaga
GROUP BY 1
ORDER BY y DESC;

        """);

        List<Object[]> results = query.getResultList();
        if (results == null || results.isEmpty()) {
            return List.of();
        }

        return results.stream()
                .map(r -> Map.of("name", r[0], "y", ((Number) r[1]).intValue()))
                .collect(Collectors.toList());
    }

    // Vagas por Estado
    public List<Map<String, Object>> findVagasPorEstado() {
        Query query = em.createNativeQuery("""
            SELECT
    estado AS name,
    COUNT(*) AS y
FROM vaga
GROUP BY estado
ORDER BY y DESC;

        """);

        List<Object[]> results = query.getResultList();
        if (results == null || results.isEmpty()) {
            return List.of();
        }

        return results.stream()
                .map(r -> Map.of("name", r[0], "y", ((Number) r[1]).intValue()))
                .collect(Collectors.toList());
    }
}
