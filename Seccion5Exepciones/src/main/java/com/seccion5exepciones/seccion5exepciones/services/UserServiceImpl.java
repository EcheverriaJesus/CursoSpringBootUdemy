package com.seccion5exepciones.seccion5exepciones.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seccion5exepciones.seccion5exepciones.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private List<User> users;

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream().filter(usr -> usr.getId().equals(id)).findFirst();
        /* for (User u : users){
            if (u.getId().equals(id)) {
                user = u;
                break;
            }
        } */
    }

}
