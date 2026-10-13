package com.peixoto.estoque.spring.controller;

import com.peixoto.estoque.spring.model.Cliente;
import com.peixoto.estoque.spring.service.ClienteService;
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
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:4200")

public class ClienteController {

    public record ClienteRequest(String nome, String email, BigDecimal idade) {
    }

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @PostMapping
    public Cliente cadastrar(@RequestBody ClienteRequest req) {
        return clienteService.cadastrarclientes(new Cliente(req.nome(), req.email(), req.idade()));
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        clienteService.deletarPorId(id);
    }
}