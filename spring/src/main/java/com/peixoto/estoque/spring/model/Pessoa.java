package com.peixoto.estoque.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "Cliente")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(
            name = "NomeCliente",
            length = 100,
            nullable = false,
            unique = true
    )
    public String nomecliente;

    @Column(
            name = "Email",
            length = 100,
            nullable = false,
            unique = true
    )
    protected String email;

    @Column(
            name = "Idade",
            precision = 3,
            scale = 0,
            nullable = false
    )
    protected BigDecimal idade;

    protected Pessoa() {
    }

    public Pessoa(String nomecliente, String email, BigDecimal idade) {
        this.nomecliente = nomecliente;
        this.idade = idade;
        this.email = email;
    }
}