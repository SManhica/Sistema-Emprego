package com.gestaoemprego.controller;

import com.gestaoemprego.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardEmpresaController {

    @Autowired
    private DashboardService service;

    @GetMapping("/empresa")
    public String empresaDashboard(Model model) {
        // Dados de exemplo (podes ajustar conforme o que o DashboardService devolve)
        //model.addAttribute("empresasPorCidade", service.getEmpresasPorCidade());
       // model.addAttribute("empresasPorRamo", service.getEmpresasPorRamo());
        //model.addAttribute("empresasPorTamanho", service.getEmpresasPorTamanho());
        //model.addAttribute("empresasPorVagas", service.getEmpresasPorNumeroDeVagas());

        return "empresa"; // o nome do ficheiro HTML Thymeleaf -> empresa.html
    }
}
