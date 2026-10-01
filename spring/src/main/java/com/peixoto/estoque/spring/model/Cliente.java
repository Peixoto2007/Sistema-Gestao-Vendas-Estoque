package com.peixoto.estoque.spring.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NomeCliente", length = 100, nullable = false)
    private String nomecliente;

    @Column(name = "Email", length = 100, nullable = false)
    private String email;

    @Column(name = "Idade", precision = 3, scale = 0, nullable = false)
    private BigDecimal idade;

    protected Cliente() {
    }

    public Cliente(String nomecliente, String email, BigDecimal idade) {
        this.nomecliente = nomecliente;
        this.email = email;
        this.idade = idade;
    }

    public Integer getId() { return id; }
    public String getNomecliente() { return nomecliente; }
    public String getEmail() { return email; }
    public BigDecimal getIdade() { return idade; }
}