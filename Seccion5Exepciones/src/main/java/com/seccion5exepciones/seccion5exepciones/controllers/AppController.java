package com.seccion5exepciones.seccion5exepciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seccion5exepciones.seccion5exepciones.exceptions.UserNotFoundException;
import com.seccion5exepciones.seccion5exepciones.models.domain.User;
import com.seccion5exepciones.seccion5exepciones.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {
    
    @Autowired
    private UserService service;

    @GetMapping
    public String index () {
        //int value = 100 / 0;
        int value = Integer.parseInt("Jesus");
        System.out.println(value);
        return "oK 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id") Long id){
        User user = service.findById(id).orElseThrow(()-> new UserNotFoundException("Error, el usuario no existe!!"));
       
        System.out.println(user.getLastname());
        return user;
    }
}
