package com.peixoto.estoque.spring.service;

import com.peixoto.estoque.spring.model.Pedido;
import com.peixoto.estoque.spring.model.Produto;
import com.peixoto.estoque.spring.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoService {

    public record ResultadoVenda(boolean sucesso, String mensagem) {
    }

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrarprodutos(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public void deletar(String codigo) {
        produtoRepository.deleteById(codigo);
    }

    public void infos() {
        System.out.println("--- Informações do Estoque ---");
        produtoRepository.findAll().forEach(Produto::info);
    }

    // Usado pela API REST: devolve o resultado em vez de imprimir no console
    public ResultadoVenda vender(String nomeProduto, BigDecimal quantidade) {

        if (quantidade == null || quantidade.signum() <= 0) {
            return new ResultadoVenda(false, "Informe uma quantidade maior que zero.");
        }

        return produtoRepository.findByNomeProdutoIgnoreCase(nomeProduto)
                .map(produto -> {
                    BigDecimal disponivel = produto.getQuantidadeDisponivel();

                    if (disponivel.compareTo(quantidade) < 0) {
                        return new ResultadoVenda(false, "Quantidade insuficiente no estoque.");
                    }

                    produto.setQuantidadeDisponivel(disponivel.subtract(quantidade));
                    produtoRepository.save(produto);

                    return new ResultadoVenda(true,
                            "Venda realizada. Quantidade restante: " + produto.getQuantidadeDisponivel());
                })
                .orElse(new ResultadoVenda(false, "Produto não encontrado no estoque."));
    }

    // Mantido para o menu de console (MenuRunner)
    public void venda(Pedido pedido) {
        System.out.println(vender(pedido.NomeProduto, pedido.QuantidadeDisponivel).mensagem());
    }
}