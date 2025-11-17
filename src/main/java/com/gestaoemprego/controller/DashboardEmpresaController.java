// src/main/java/com/gestaoemprego/controller/DashboardEmpresaController.java
package com.gestaoemprego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardEmpresaController {

    @GetMapping("/empresa")
    public String empresaDashboard() {
        return "empresa";
    }
}
