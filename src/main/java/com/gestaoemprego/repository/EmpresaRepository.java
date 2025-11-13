package com.gestaoemprego.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class EmpresaRepository {

    @PersistenceContext
    private EntityManager em;

    // Empresas por Cidade (usando Endereco -> Distrito -> Provincia)
    public List<Map<String, Object>> findEmpresasPorCidade() {
        Query query = em.createNativeQuery("""
            SELECT dist.nome AS name, COUNT(DISTINCT e.id_empresa) AS y
            FROM empresa e
            JOIN empresaendereco ee ON e.id_empresa = ee.id_empresa
            JOIN endereco endr ON ee.id_endereco = endr.id_endereco
            JOIN distrito dist ON endr.id_distrito = dist.id_distrito
            GROUP BY dist.nome
            ORDER BY y DESC
        """);

        List<Object[]> results = query.getResultList();
        if (results == null || results.isEmpty()) return List.of();

        return results.stream()
                .map(r -> Map.of("name", r[0], "y", ((Number) r[1]).intValue()))
                .collect(Collectors.toList());
    }

    //  Empresas por Sector/Ramo
    public List<Map<String, Object>> findEmpresasPorRamo() {
        Query query = em.createNativeQuery("""
            SELECT sector AS name, COUNT(*) AS y
            FROM empresa
            GROUP BY sector
            ORDER BY y DESC
        """);

        List<Object[]> results = query.getResultList();
        if (results == null || results.isEmpty()) return List.of();

        return results.stream()
                .map(r -> Map.of("name", r[0], "y", ((Number) r[1]).intValue()))
                .collect(Collectors.toList());
    }

    // Empresas por Tamanho (baseado no número de vagas: Pequena <5, Média 5-20, Grande >20)
    public List<Map<String, Object>> findEmpresasPorTamanho() {
        Query query = em.createNativeQuery("""
            SELECT CASE
                       WHEN vagas.count < 5 THEN 'Pequena'
                       WHEN vagas.count BETWEEN 5 AND 20 THEN 'Média'
                       ELSE 'Grande'
                   END AS name,
                   COUNT(*) AS y
            FROM empresa e
            LEFT JOIN (
                SELECT id_empresa, COUNT(*) AS count
                FROM vaga
                GROUP BY id_empresa
            ) vagas ON e.id_empresa = vagas.id_empresa
            GROUP BY name
            ORDER BY name
        """);

        List<Object[]> results = query.getResultList();
        if (results == null || results.isEmpty()) return List.of();

        return results.stream()
                .map(r -> Map.of("name", r[0], "y", ((Number) r[1]).intValue()))
                .collect(Collectors.toList());
    }

    // Empresas por Número de Vagas
    public List<Map<String, Object>> findEmpresasPorNumeroDeVagas() {
        Query query = em.createNativeQuery("""
            SELECT e.nome AS name, COUNT(v.id_vaga) AS y
            FROM empresa e
            LEFT JOIN vaga v ON e.id_empresa = v.id_empresa
            GROUP BY e.nome
            ORDER BY y DESC
        """);

        List<Object[]> results = query.getResultList();
        if (results == null || results.isEmpty()) return List.of();

        return results.stream()
                .map(r -> Map.of("name", r[0], "y", ((Number) r[1]).intValue()))
                .collect(Collectors.toList());
    }
}

