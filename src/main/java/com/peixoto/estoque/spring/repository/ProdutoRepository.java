package com.peixoto.estoque.spring.repository;

import com.peixoto.estoque.spring.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    Optional<Produto> findByNomeProdutoIgnoreCase(String nomeProduto);
}