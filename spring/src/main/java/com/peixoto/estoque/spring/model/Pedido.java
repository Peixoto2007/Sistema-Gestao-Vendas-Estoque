package com.peixoto.estoque.spring.model;

import java.math.BigDecimal;

public class Pedido {

    public String NomeProduto;
    public BigDecimal QuantidadeDisponivel;

    public Pedido(String nomeProduto, BigDecimal quantidade) {
        this.NomeProduto = nomeProduto;
        this.QuantidadeDisponivel = quantidade;
    }
}