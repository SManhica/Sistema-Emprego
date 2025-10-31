package com.gestaoemprego.controller;

import com.gestaoemprego.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardCandidatosController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard/candidatos")
    public String dashboardCandidatos(Model model) {
       // model.addAttribute("candidatosPorGenero", dashboardService.getCandidatosPorGenero());
        //model.addAttribute("candidatosPorCidade", dashboardService.getCandidatosPorCidade());
        //model.addAttribute("candidatosPorServico", dashboardService.getCandidatosPorServico());
        //model.addAttribute("candidatosPorFaixaEtaria", dashboardService.getCandidatosPorFaixaEtaria());
        return "dashboard-candidatos";
    }
}
