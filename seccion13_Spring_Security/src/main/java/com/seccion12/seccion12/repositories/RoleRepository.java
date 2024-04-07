package com.seccion12.seccion12.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.seccion12.seccion12.entities.Role;

public interface RoleRepository extends CrudRepository <Role, Long>{

    Optional<Role> findByName(String name);
  
}
