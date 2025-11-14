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

    //  vagas por Estado
    public List<Map<String, Object>> getVagasByEstado() {
        return vagaRepository.findVagasByEstado();
    }
    // vagas por Estado tabela
  public List<Map<String, Object>> getVagasporEstado() {
        return vagaRepository.findVagasPorEstado();
    }

}
