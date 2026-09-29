package com.peixoto.estoque.spring.service;

import com.peixoto.estoque.spring.model.Cliente;
import com.peixoto.estoque.spring.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void cadastrarclientes(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public boolean existePorNome(String nome) {
        return clienteRepository.existsByNomeclienteIgnoreCase(nome);
    }

    public void info_clientes() {
        System.out.println("--- Informações dos Clientes ---");
        clienteRepository.findAll().forEach(c ->
                System.out.println("Nome: " + c.getNomecliente() + " | Email: " + c.getEmail())
        );
    }

    public void deletarcliente(String email) {
        clienteRepository.findByEmail(email).ifPresentOrElse(
                clienteRepository::delete,
                () -> System.out.println("Cliente não foi encontrado")
        );
    }
}