package com.peixoto.estoque.spring.controller;

import com.peixoto.estoque.spring.service.ClienteService;
import com.peixoto.estoque.spring.service.ProdutoService;
import com.peixoto.estoque.spring.service.ProdutoService.ResultadoVenda;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoController {

    public record PedidoRequest(String cliente, String produto, BigDecimal quantidade) {
    }

    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    public PedidoController(ClienteService clienteService, ProdutoService produtoService) {
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResultadoVenda fazerPedido(@RequestBody PedidoRequest req) {


        if (!clienteService.existePorNome(req.cliente())) {
            return new ResultadoVenda(false, "Cliente não está cadastrado.");
        }

        return produtoService.vender(req.produto(), req.quantidade());
    }
}