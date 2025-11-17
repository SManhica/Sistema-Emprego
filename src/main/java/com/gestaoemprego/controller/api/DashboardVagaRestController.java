// src/main/java/com/gestaoemprego/controller/api/DashboardVagaRestController.java
package com.gestaoemprego.controller.api;

import com.gestaoemprego.dto.ChartDataDTO;
import com.gestaoemprego.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vaga")
public class DashboardVagaRestController {

    @Autowired
    private VagaService vagaService;

    @GetMapping("/sector")
    public ResponseEntity<ChartDataDTO> getVagasPorSector() {
        List<Map<String, Object>> data = vagaService.getVagasPorSector();
        ChartDataDTO dto = new ChartDataDTO("Vagas por Sector", data);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/estado")
    public ResponseEntity<ChartDataDTO> getVagasByEstado() {
        List<Map<String, Object>> data = vagaService.getVagasByEstado();
        ChartDataDTO dto = new ChartDataDTO("Vagas por Estado", data);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/estado-tabela")
    public ResponseEntity<ChartDataDTO> getVagasporEstado() {
        List<Map<String, Object>> data = vagaService.getVagasporEstado();
        ChartDataDTO dto = new ChartDataDTO("Vagas por Estado (Tabela)", data);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/mes")
    public ResponseEntity<ChartDataDTO> getVagasPorMes() {
        List<Map<String, Object>> data = vagaService.getVagasPorMes();
        ChartDataDTO dto = new ChartDataDTO("Publicação de Vagas (Últimos 6 Meses)", data);
        return ResponseEntity.ok(dto);
    }
}