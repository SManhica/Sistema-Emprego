// src/main/java/com/gestaoemprego/controller/DashboardVagaController.java
package com.gestaoemprego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardVagaController {

    @GetMapping("/vagas")
    public String vagaDashboard() {
        return "vagas";
    }
}