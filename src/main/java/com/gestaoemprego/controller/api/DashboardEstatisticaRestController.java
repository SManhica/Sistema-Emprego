// src/main/java/com/gestaoemprego/controller/api/DashboardEstatisticaRestController.java
package com.gestaoemprego.controller.api;

import com.gestaoemprego.dto.ChartDataDTO;
import com.gestaoemprego.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardEstatisticaRestController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/vagas-por-sector")
    public ResponseEntity<ChartDataDTO> getVagasPorSector() {
        List<Map<String, Object>> data = dashboardService.getVagasPorSector();
        ChartDataDTO dto = new ChartDataDTO("Vagas por Sector", data);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/candidatos-por-genero")
    public ResponseEntity<ChartDataDTO> getCandidatosPorGenero() {
        List<Map<String, Object>> data = dashboardService.getCandidatosPorGenero();
        ChartDataDTO dto = new ChartDataDTO("Candidatos por Género", data);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/vagas-por-mes")
    public ResponseEntity<ChartDataDTO> getVagasPorMes() {
        List<Map<String, Object>> data = dashboardService.getVagasPorMesUltimos6Meses();
        ChartDataDTO dto = new ChartDataDTO("Vagas por Mês (Últimos 6 Meses)", data);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/top-servicos")
    public ResponseEntity<ChartDataDTO> getTop10Servicos() {
        List<Map<String, Object>> data = dashboardService.getTop10ServicosComCandidatos();
        ChartDataDTO dto = new ChartDataDTO("Top 10 Serviços com Mais Candidatos", data);
        return ResponseEntity.ok(dto);
    }
}