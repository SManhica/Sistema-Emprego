// src/main/java/com/gestaoemprego/controller/api/DashboardEmpresaRestController.java
package com.gestaoemprego.controller.api;

import com.gestaoemprego.dto.ChartDataDTO;
import com.gestaoemprego.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/empresa")
public class DashboardEmpresaRestController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/distrito")
    public ResponseEntity<ChartDataDTO> getEmpresasPorDistrito() {
        List<Map<String, Object>> data = empresaService.getEmpresasPorDistrito();
        ChartDataDTO dto = new ChartDataDTO("Empresas por Distrito", data);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/ramo")
    public ResponseEntity<ChartDataDTO> getEmpresasPorRamo() {
        List<Map<String, Object>> data = empresaService.getEmpresasPorRamo();
        ChartDataDTO dto = new ChartDataDTO("Empresas por Sector", data);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/tamanho")
    public ResponseEntity<ChartDataDTO> getEmpresasPorTamanho() {
        List<Map<String, Object>> data = empresaService.getEmpresasPorTamanho();
        ChartDataDTO dto = new ChartDataDTO("Tamanho das Empresas", data);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/vagas")
    public ResponseEntity<ChartDataDTO> getEmpresasPorNumeroDeVagas() {
        List<Map<String, Object>> data = empresaService.getEmpresasPorNumeroDeVagas();
        ChartDataDTO dto = new ChartDataDTO("Vagas Publicadas por Empresa", data);
        return ResponseEntity.ok(dto);
    }
}