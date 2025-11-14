package com.gestaoemprego.controller;

import com.gestaoemprego.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardVagaController {

    @Autowired
    private VagaService service;

    @GetMapping("/vagas")
    public String vagaDashboard(Model model) {
        //Dados para os gráficos
       model.addAttribute("vagasPorSector", service.getVagasPorSector());
       model.addAttribute("vagasporEstado", service.getVagasporEstado());
       model.addAttribute("vagasPorMes", service.getVagasPorMes());
       model.addAttribute("vagasByEstado", service.getVagasByEstado());

        return "vagas"; // nome do template Thymeleaf: vagas.html
    }
}
