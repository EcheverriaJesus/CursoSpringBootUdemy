package com.seccion30.seccion30.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seccion30.seccion30.entities.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{



}
