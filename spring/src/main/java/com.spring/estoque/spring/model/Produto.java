package com.estoque.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.math.BigDecimal;


@Entity
@Table(name = "Estoque")
public class Produto {

    @Column(name="NomeProduto",
    length=100,
    nullable=false,
    unique=true)
    public String NomeProduto;

    @Id
    @Column(name="CodigoProduto",
            length=6,
            nullable=false)
    private String CodigoProduto;

    @Column(name="QuantidadeDisponivel",
            precision=3,
            scale=0,
            nullable=false)
    public BigDecimal QuantidadeDisponivel;


    protected Produto() {
    }

    public Produto(String CodigoProduto, String NomeProduto, BigDecimal QuantidadeDisponivel) {

        this.CodigoProduto = CodigoProduto;
        this.NomeProduto = NomeProduto;
        this.QuantidadeDisponivel = QuantidadeDisponivel;
    }

    public void info() {

        System.out.println("Codigo do Produto: " + CodigoProduto);
        System.out.println("Nome do Produto: " + NomeProduto);
        System.out.println("Quantidade em Estoque: " + QuantidadeDisponivel);
    }
}