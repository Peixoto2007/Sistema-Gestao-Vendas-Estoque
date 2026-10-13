package com.peixoto.estoque.spring.controller;

import com.peixoto.estoque.spring.model.Produto;
import com.peixoto.estoque.spring.service.ProdutoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController {

    public record ProdutoRequest(String codigo, String nome, BigDecimal quantidade) {
    }

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listar();
    }

    @PostMapping
    public Produto cadastrar(@RequestBody ProdutoRequest req) {
        return produtoService.cadastrarprodutos(new Produto(req.codigo(), req.nome(), req.quantidade()));
    }

    @DeleteMapping("/{codigo}")
    public void excluir(@PathVariable String codigo) {
        produtoService.deletar(codigo);
    }
}