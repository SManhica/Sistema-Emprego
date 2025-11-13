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

    // 3. Candidatos por distrito
    public List<Map<String, Object>> findCandidatosPorDistrito() {
        Query query = em.createNativeQuery("""
                                    SELECT dist.nome AS name, COUNT(*) AS y
                FROM candidato c
                JOIN CandidatoEndereco ce ON c.id_candidato = ce.id_candidato
                JOIN endereco e ON ce.id_endereco = e.id_endereco
                JOIN distrito dist ON e.id_distrito = dist.id_distrito
                GROUP BY dist.nome
                ORDER BY y DESC
                limit 10

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
                    SELECT fa.curso AS name, COUNT(*) AS y
                    FROM formacaoacademica fa
                    JOIN candidato c ON fa.id_candidato = c.id_candidato
                    GROUP BY fa.curso
                    ORDER BY y DESC
                    limit 10
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
