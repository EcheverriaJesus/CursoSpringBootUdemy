package com.seccion5exepciones.seccion5exepciones.services;

import java.util.List;
import java.util.Optional;

import com.seccion5exepciones.seccion5exepciones.models.domain.User;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);
}
