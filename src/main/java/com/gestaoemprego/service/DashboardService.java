package com.gestaoemprego.service;

import com.gestaoemprego.repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    public List<Map<String, Object>> getVagasPorSector() {
        return dashboardRepository.findVagasPorSector();
    }

    public List<Map<String, Object>> getCandidatosPorGenero() {
        return dashboardRepository.findCandidatosPorGenero();
    }

    public List<Map<String, Object>> getVagasPorMesUltimos6Meses() {
        return dashboardRepository.findVagasPorMesUltimos6Meses();
    }

    public List<Map<String, Object>> getTop10ServicosComCandidatos() {
    return dashboardRepository.findTop10ServicosComCandidatos();
}





}