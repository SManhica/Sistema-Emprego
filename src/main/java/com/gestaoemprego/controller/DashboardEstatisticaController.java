package com.gestaoemprego.controller;

import com.gestaoemprego.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class DashboardEstatisticaController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("vagasPorSector", dashboardService.getVagasPorSector());
        model.addAttribute("candidatosPorGenero", dashboardService.getCandidatosPorGenero());
        model.addAttribute("vagasPorMes", dashboardService.getVagasPorMesUltimos6Meses());
        model.addAttribute("top10Servicos", dashboardService.getTop10ServicosComCandidatos());
        return "dashboard";
    }
}