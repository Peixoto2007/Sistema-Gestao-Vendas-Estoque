package com.peixoto.estoque.spring.repository;

import com.peixoto.estoque.spring.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa , Integer>{

        };