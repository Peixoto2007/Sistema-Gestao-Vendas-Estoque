package com.peixoto.estoque.spring.view;

import com.peixoto.estoque.spring.model.Cliente;
import com.peixoto.estoque.spring.model.Pedido;
import com.peixoto.estoque.spring.model.Produto;
import com.peixoto.estoque.spring.service.ClienteService;
import com.peixoto.estoque.spring.service.ProdutoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
@ConditionalOnProperty(name = "app.console", havingValue = "true")
public class MenuRunner implements CommandLineRunner {

    private final ProdutoService produtoService;
    private final ClienteService clienteService;
    private final Scanner scanner = new Scanner(System.in);

    public MenuRunner(ProdutoService produtoService, ClienteService clienteService) {
        this.produtoService = produtoService;
        this.clienteService = clienteService;
    }

    @Override
    public void run(String... args) {

        boolean rodando = true;

        while (rodando) {

            imprimirMenu();


            int opcao = lerInteiro("Escolha uma opção:");

            switch (opcao) {
                case 1 -> cadastrarProduto();
                case 2 -> cadastrarCliente();
                case 3 -> fazerPedido();
                case 4 -> {
                    clienteService.info_clientes();
                    produtoService.infos();
                }
                case 5 -> excluirCliente();
                case 6 -> System.out.println("Atualização ainda não implementada.");
                case 7 -> rodando = false;
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void imprimirMenu() {
        System.out.println("--- Sistema de Gestão de Vendas e Estoque ---");
        System.out.println("1 - Cadastrar novo produto");
        System.out.println("2 - Cadastrar novo cliente");
        System.out.println("3 - Fazer pedido");
        System.out.println("4 - Ver informações");
        System.out.println("5 - Excluir usuário");
        System.out.println("6 - Atualizar usuário");
        System.out.println("7 - Sair");
    }

    private void cadastrarProduto() {
        String codigo = lerTexto("Qual o código do produto? (até 6 caracteres)");

        if (codigo.length() > 6) {
            System.out.println("O código deve ter no máximo 6 caracteres.");
            return;
        }

        String nome = lerTexto("Qual o nome do produto?");
        int quantidade = lerInteiro("Qual a quantidade?");

        produtoService.cadastrarprodutos(new Produto(codigo, nome, BigDecimal.valueOf(quantidade)));
        System.out.println("Produto cadastrado.");
    }

    private void cadastrarCliente() {
        String nome = lerTexto("Qual o nome do cliente?");
        int idade = lerInteiro("Qual a idade do cliente?");
        String email = lerTexto("Qual o e-mail do cliente?");

        clienteService.cadastrarclientes(new Cliente(nome, email, BigDecimal.valueOf(idade)));
        System.out.println("Cliente cadastrado.");
    }

    private void fazerPedido() {
        String nomeCliente = lerTexto("Qual o nome do cliente?");

        if (!clienteService.existePorNome(nomeCliente)) {
            System.out.println("Cliente não está cadastrado.");
            return;
        }

        System.out.println("Cliente localizado!");

        String nomeProduto = lerTexto("Qual o nome do produto?");
        int quantidade = lerInteiro("Qual a quantidade?");

        produtoService.venda(new Pedido(nomeProduto, BigDecimal.valueOf(quantidade)));
    }

    private void excluirCliente() {
        String email = lerTexto("Digite o e-mail registrado do usuário:");
        clienteService.deletarcliente(email);
    }

    // Repete a pergunta até a pessoa digitar algo
    private String lerTexto(String pergunta) {
        while (true) {
            System.out.println(pergunta);
            String texto = scanner.nextLine().trim();

            if (!texto.isBlank()) {
                return texto;
            }
            System.out.println("Digite algo.");
        }
    }

    // Repete a pergunta até a pessoa digitar um número inteiro maior que zero
    private int lerInteiro(String pergunta) {
        while (true) {
            System.out.println(pergunta);
            try {
                int numero = Integer.parseInt(scanner.nextLine().trim());

                if (numero > 0) {
                    return numero;
                }
                System.out.println("Digite um número maior que zero.");
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }
}