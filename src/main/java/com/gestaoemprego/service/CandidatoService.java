package com.gestaoemprego.service;

import com.gestaoemprego.repository.CandidatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    public CandidatoService(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

 
    public List<Map<String, Object>> getCandidatosPorGenero() {
        return candidatoRepository.findCandidatosPorGenero();
    }

   
    public List<Map<String, Object>> getCandidatosPorFaixaEtaria() {
        return candidatoRepository.findCandidatosPorFaixaEtaria();
    }


    public List<Map<String, Object>> getCandidatosPorCidade() {
        return candidatoRepository.findCandidatosPorCidade();
    }


    public List<Map<String, Object>> getCandidatosPorFormacao() {
        return candidatoRepository.findCandidatosPorFormacao();
    }
}
