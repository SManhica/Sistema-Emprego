// src/main/java/com/gestaoemprego/controller/DashboardEstatisticaController.java
package com.gestaoemprego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardEstatisticaController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}