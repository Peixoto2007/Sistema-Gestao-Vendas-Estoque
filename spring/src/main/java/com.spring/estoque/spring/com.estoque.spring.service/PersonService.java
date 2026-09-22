package com.estoque.spring.service;

import com.estoque.spring.model.Pessoa;
import com.estoque.spring.repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService{

    private final PessoaRepository pessoaRepository;

    public PersonService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    };

    public void inserirPessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

};
