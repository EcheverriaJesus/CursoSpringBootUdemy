package com.seccion28.seccion28.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({ "/", "index" })
    public String index(Model model) {
        model.addAttribute("titulo", "Bienvenido al area de atencjuon a clientes");
        return "index";
    }

    @GetMapping("/cerrado")
    public String cerrrado(Model model) {
        model.addAttribute("titulo", "Fuera del horario");
        model.addAttribute("mensaje", "Fuera de servicio");
        return "cerrado";
    }
    
}
