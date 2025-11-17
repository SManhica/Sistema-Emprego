// src/main/java/com/gestaoemprego/controller/api/DashboardCandidatoRestController.java
package com.gestaoemprego.controller.api;

import com.gestaoemprego.dto.ChartDataDTO;
import com.gestaoemprego.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/candidato")
public class DashboardCandidatoRestController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping("/genero")
    public ResponseEntity<ChartDataDTO> getCandidatosPorGenero() {
        List<Map<String, Object>> data = candidatoService.getCandidatosPorGenero();
        ChartDataDTO dto = new ChartDataDTO("Candidatos por Género", data);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/idade")
    public ResponseEntity<ChartDataDTO> getCandidatosPorFaixaEtaria() {
        List<Map<String, Object>> data = candidatoService.getCandidatosPorFaixaEtaria();
        ChartDataDTO dto = new ChartDataDTO("Candidatos por Faixa Etária", data);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/distrito")
    public ResponseEntity<ChartDataDTO> getCandidatosPorDistrito() {
        List<Map<String, Object>> data = candidatoService.getCandidatosPorDistrito();
        ChartDataDTO dto = new ChartDataDTO("Candidatos por Distrito", data);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/formacao")
    public ResponseEntity<ChartDataDTO> getCandidatosPorFormacao() {
        List<Map<String, Object>> data = candidatoService.getCandidatosPorFormacao();
        ChartDataDTO dto = new ChartDataDTO("Candidatos por Nível de Formação", data);
        return ResponseEntity.ok(dto);
    }
}
