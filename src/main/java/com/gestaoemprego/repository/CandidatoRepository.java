package com.gestaoemprego.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CandidatoRepository {

    @PersistenceContext
    private EntityManager em;

    // 1. Candidatos por gênero
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

    // 2. Candidatos por faixa etária
    public List<Map<String, Object>> findCandidatosPorFaixaEtaria() {
        Query query = em.createNativeQuery("""
                           SELECT
                    CASE
                        WHEN EXTRACT(YEAR FROM AGE(current_date, data_nascimento)) BETWEEN 15 AND 16 THEN '15-16'
                        WHEN EXTRACT(YEAR FROM AGE(current_date, data_nascimento)) BETWEEN 17 AND 20 THEN '17-20'
                        WHEN EXTRACT(YEAR FROM AGE(current_date, data_nascimento)) BETWEEN 21 AND 24 THEN '21-24'
                        WHEN EXTRACT(YEAR FROM AGE(current_date, data_nascimento)) BETWEEN 25 AND 60 THEN '25-60'
                        ELSE '60+'
                    END AS name,
                    COUNT(*) AS y
                FROM candidato
                GROUP BY name
                ORDER BY name;

                        """);

        List<Object[]> results = query.getResultList();
        if (results == null || results.isEmpty()) {
            return List.of();
        }

        return results.stream()
                .map(r -> Map.of("name", r[0], "y", ((Number) r[1]).intValue()))
                .collect(Collectors.toList());
    }

    // 3. Candidatos por cidade
    public List<Map<String, Object>> findCandidatosPorCidade() {
        Query query = em.createNativeQuery("""
                    SELECT cidade AS name, COUNT(*) AS y
                    FROM candidato
                    GROUP BY cidade
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

    // 4. Candidatos por nível de formação
    public List<Map<String, Object>> findCandidatosPorFormacao() {
        Query query = em.createNativeQuery("""
                    SELECT nivel_formacao AS name, COUNT(*) AS y
                    FROM candidato
                    GROUP BY nivel_formacao
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
}
