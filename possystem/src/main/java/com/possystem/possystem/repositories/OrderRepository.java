package com.possystem.possystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.possystem.possystem.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
