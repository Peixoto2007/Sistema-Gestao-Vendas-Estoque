package com.peixoto.estoque.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Estoque")
public class Produto {

    @Id
    @Column(name = "CodigoProduto", length = 6, nullable = false)
    private String codigoProduto;

    @Column(name = "NomeProduto", length = 100, nullable = false, unique = true)
    private String nomeProduto;

    @Column(name = "QuantidadeDisponivel", nullable = false)
    private Integer quantidadeDisponivel;

    protected Produto() {
    }

    public Produto(String codigoProduto, String nomeProduto, Integer quantidadeDisponivel) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getCodigoProduto() { return codigoProduto; }
    public String getNomeProduto() { return nomeProduto; }
    public Integer getQuantidadeDisponivel() { return quantidadeDisponivel; }
    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public void info() {
        System.out.println("Codigo do Produto: " + codigoProduto);
        System.out.println("Nome do Produto: " + nomeProduto);
        System.out.println("Quantidade em Estoque: " + quantidadeDisponivel);
    }
}