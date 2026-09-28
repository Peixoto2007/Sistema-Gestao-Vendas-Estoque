package com.peixoto.estoque.spring.service;

import com.peixoto.estoque.spring.model.Produto;
import com.peixoto.estoque.spring.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void inserirProduto(Produto produto) {
        produtoRepository.save(produto);
    }
}