package com.peixoto.estoque.spring.model;

public class Pedido {

    public String NomeProduto;
    public int QuantidadeDisponivel;

    public Pedido(String nomeProduto, int quantidade) {
        this.NomeProduto = nomeProduto;
        this.QuantidadeDisponivel = quantidade;
    }
}