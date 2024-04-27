package com.oauth2_2.oauth2_2.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oauth2_2.oauth2_2.models.Message;

@RestController
public class AppController {

    @GetMapping("/list")
    public List<Message> list() {
        return Collections.singletonList(new Message("test list"));
    }

    @PostMapping("/create")
    public Message create(@RequestBody Message message){
        System.out.println("Mensjae guardado" + message);
        return message;
    }

    public Map<String, String> authorized(@RequestParam String code) {
        return Collections.singletonMap("code", code);
    }
}
