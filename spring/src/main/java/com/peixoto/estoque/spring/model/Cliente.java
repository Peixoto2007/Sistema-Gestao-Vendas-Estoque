package com.peixoto.estoque.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NomeCliente", length = 100, nullable = false)
    private String nomecliente;

    @Column(name = "Email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "Idade", nullable = false)
    private Integer idade;

    protected Cliente() {
    }

    public Cliente(String nomecliente, String email, Integer idade) {
        this.nomecliente = nomecliente;
        this.email = email;
        this.idade = idade;
    }

    // getters (necessários pro Service/Main acessarem os dados)
    public Integer getId() { return id; }
    public String getNomecliente() { return nomecliente; }
    public String getEmail() { return email; }
    public Integer getIdade() { return idade; }
}