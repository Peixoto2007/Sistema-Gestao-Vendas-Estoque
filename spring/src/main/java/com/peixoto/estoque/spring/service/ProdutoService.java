package com.peixoto.estoque.spring.service;

import com.peixoto.estoque.spring.model.Pedido;
import com.peixoto.estoque.spring.model.Produto;
import com.peixoto.estoque.spring.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void cadastrarprodutos(Produto produto) {
        produtoRepository.save(produto);
    }

    public void infos() {
        System.out.println("--- Informações do Estoque ---");
        produtoRepository.findAll().forEach(Produto::info);
    }

    public void venda(Pedido pedido) {
        produtoRepository.findByNomeProdutoIgnoreCase(pedido.NomeProduto).ifPresentOrElse(
                produto -> {
                    int disponivel = produto.getQuantidadeDisponivel();
                    int solicitado = (int) pedido.QuantidadeDisponivel;

                    if (disponivel >= solicitado) {
                        produto.setQuantidadeDisponivel(disponivel - solicitado);
                        produtoRepository.save(produto);
                        System.out.println("Venda realizada!");
                        System.out.println("Quantidade restante: " + produto.getQuantidadeDisponivel());
                    } else {
                        System.out.println("Quantidade insuficiente no estoque!");
                    }
                },
                () -> System.out.println("Produto não encontrado no estoque.")
        );
    }
}