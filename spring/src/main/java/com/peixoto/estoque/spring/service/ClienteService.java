package com.peixoto.estoque.spring.service;

import com.peixoto.estoque.spring.model.Cliente;
import com.peixoto.estoque.spring.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){

        this.clienteRepository = clienteRepository;
    };

    public void inserirPessoa(Cliente pessoa) {

        clienteRepository.save(pessoa);
    }

};
