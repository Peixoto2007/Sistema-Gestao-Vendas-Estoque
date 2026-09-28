package com.peixoto.estoque.spring.repository;

import com.peixoto.estoque.spring.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

        };