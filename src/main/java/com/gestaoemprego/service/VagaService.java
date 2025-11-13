package com.gestaoemprego.service;

import com.gestaoemprego.repository.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VagaService {

    private final VagaRepository vagaRepository;

    public VagaService(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    //  Vagas por Sector
    public List<Map<String, Object>> getVagasPorSector() {
        return vagaRepository.findVagasPorSector();
    }

    // Vagas por Mês (últimos 6 meses)
    public List<Map<String, Object>> getVagasPorMes() {
        return vagaRepository.findVagasPorMesUltimos6Meses();
    }

    //  Top distritos  com mais candidatos
    public List<Map<String, Object>> getTopCidadesComMaisCandidatos() {
        return vagaRepository.findTopCidadesComMaisCandidatos();
    }
    // Candidatos por Gênero
  public List<Map<String, Object>> getCandidatosPorGenero() {
        return vagaRepository.findCandidatosPorGenero();
    }

}
