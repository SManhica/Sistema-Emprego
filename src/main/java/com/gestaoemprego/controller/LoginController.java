// src/main/java/com/gestaoemprego/controller/LoginController.java
package com.gestaoemprego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username,
                              @RequestParam String password,
                              Model model) {

        if ("admin".equals(username) && "1234".equals(password)) {
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Usuário ou senha inválidos!");
            return "login";
        }
    }
}