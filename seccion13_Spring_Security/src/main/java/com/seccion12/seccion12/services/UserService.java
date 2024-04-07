package com.seccion12.seccion12.services;

import java.util.List;

import com.seccion12.seccion12.entities.User;


public interface UserService {

    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);
}
