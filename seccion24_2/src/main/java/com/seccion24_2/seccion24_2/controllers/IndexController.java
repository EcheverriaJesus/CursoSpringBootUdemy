package com.seccion24_2.seccion24_2.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seccion24_2.seccion24_2.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
    
    @GetMapping("/index")
    public String index(Model model) {
       model.addAttribute("titulo", "Mi nombre es Jesus como titulooooo");
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setName("Noee");
        usuario.setLastname("Medina");
        usuario.setEmail("jesus@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getName()));
        return "perfil";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Usuario> usuarios = new ArrayList<>();
        
        usuarios.add(new Usuario("Suli", "Medina", "Suli@Gmail"));
        usuarios.add(new Usuario("Adriana", "Medina", "Adris@Gmail"));
        usuarios.add(new Usuario("Mati", "Medina", "Mat@Gmail"));

        model.addAttribute("titulo", "Lista de usuarios");
        model.addAttribute("usuarios", usuarios);
        return "listar";
    }
}
