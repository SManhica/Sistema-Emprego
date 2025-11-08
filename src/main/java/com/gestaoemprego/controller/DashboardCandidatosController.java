package com.gestaoemprego.controller;

import com.gestaoemprego.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardCandidatosController {

    @Autowired
    private CandidatoService service;

    @GetMapping("candidato")
    public String candidatoDashboard(Model model) {
        model.addAttribute("candidatosPorGenero", service.getCandidatosPorGenero());
        model.addAttribute("candidatosPorFaixaEtaria", service.getCandidatosPorFaixaEtaria());
        model.addAttribute("candidatosPorDistrito", service.getCandidatosPorDistrito());
        model.addAttribute("candidatosPorFormacao", service.getCandidatosPorFormacao());
        return "candidato";
}

}
