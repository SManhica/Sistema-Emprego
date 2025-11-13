package com.gestaoemprego.service;

import com.gestaoemprego.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    // Empresas por Cidade
    public List<Map<String, Object>> getEmpresasPorCidade() {
        return empresaRepository.findEmpresasPorCidade();
    }

    // Empresas por Ramo
    public List<Map<String, Object>> getEmpresasPorRamo() {
        return empresaRepository.findEmpresasPorRamo();
    }

    // Empresas por Tamanho
    public List<Map<String, Object>> getEmpresasPorTamanho() {
        return empresaRepository.findEmpresasPorTamanho();
    }

    // Empresas por Número de Vagas
    public List<Map<String, Object>> getEmpresasPorNumeroDeVagas() {
        return empresaRepository.findEmpresasPorNumeroDeVagas();
    }
}

