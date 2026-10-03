package com.peixoto.estoque.spring.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nomecliente", length = 100, nullable = false)
    private String nomecliente;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "idade", precision = 3, scale = 0, nullable = false)
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