package com.seccion5exepciones.seccion5exepciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seccion5exepciones.seccion5exepciones.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    List<User> users() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Jesus", "Echeverria"));
        users.add(new User(2L, "Noe", "Medina"));
        users.add(new User(3L, "David", "Echeverria"));
        users.add(new User(4L, "Suli", "Medina"));
        users.add(new User(5L, "Adriana", "Echeverria"));

        return users;
    }

}
