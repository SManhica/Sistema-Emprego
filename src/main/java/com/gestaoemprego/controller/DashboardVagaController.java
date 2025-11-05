package com.gestaoemprego.controller;

import com.gestaoemprego.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardVagaController {

    @Autowired
    private DashboardService service;

    @GetMapping("/vagas")
    public String vagaDashboard(Model model) {
        // Dados para os gráficos
        //model.addAttribute("vagasPorSector", service.getVagasPorSector());
        //model.addAttribute("candidatosPorGenero", service.getCandidatosPorGenero());
       // model.addAttribute("vagasPorMes", service.getVagasPorMes());
       // model.addAttribute("topCidades", service.getTopCidadesComMaisCandidatos());

        return "vagas"; // nome do template Thymeleaf: vagas.html
    }
}
