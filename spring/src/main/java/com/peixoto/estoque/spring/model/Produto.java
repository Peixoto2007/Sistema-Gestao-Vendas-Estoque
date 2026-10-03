package com.peixoto.estoque.spring.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "estoque")
public class Produto {

    @Id
    @Column(name = "codigoproduto", length = 6, nullable = false)
    private String codigoProduto;

    @Column(name = "nomeproduto", length = 100, nullable = false)
    private String nomeProduto;

    @Column(name = "quantidadedisponivel", precision = 3, scale = 0, nullable = false)
    private BigDecimal quantidadeDisponivel;

    protected Produto() {
    }

    public Produto(String codigoProduto, String nomeProduto, BigDecimal quantidadeDisponivel) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getCodigoProduto() { return codigoProduto; }
    public String getNomeProduto() { return nomeProduto; }
    public BigDecimal getQuantidadeDisponivel() { return quantidadeDisponivel; }
    public void setQuantidadeDisponivel(BigDecimal quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public void info() {
        System.out.println("Codigo do Produto: " + codigoProduto);
        System.out.println("Nome do Produto: " + nomeProduto);
        System.out.println("Quantidade em Estoque: " + quantidadeDisponivel);
    }
}