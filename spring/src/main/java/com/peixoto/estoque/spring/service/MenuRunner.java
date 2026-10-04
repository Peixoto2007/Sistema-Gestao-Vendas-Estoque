package com.peixoto.estoque.spring.service;

import com.peixoto.estoque.spring.model.Cliente;
import com.peixoto.estoque.spring.model.Pedido;
import com.peixoto.estoque.spring.model.Produto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class MenuRunner implements CommandLineRunner {

    private final ProdutoService produtoService;
    private final ClienteService clienteService;

    public MenuRunner(ProdutoService produtoService,
                      ClienteService clienteService) {

        this.produtoService = produtoService;
        this.clienteService = clienteService;
    }

    @Override
    public void run(String... args) {

        Scanner question = new Scanner(System.in);

        int contador = 0;

        while (contador == 0) {

            System.out.println("--- Sistema de Gestão de Vendas e Estoque ---");
            System.out.println("Bem vindo ao Nosso Sistema.");

            System.out.println("1 - Cadastrar novo produto");
            System.out.println("2 - Cadastrar novo cliente");
            System.out.println("3 - Fazer pedido");
            System.out.println("4 - Ver informações");
            System.out.println("5 - Excluir usuário");
            System.out.println("6 - Atualizar usuário");
            System.out.println("7 - Sair");

            int opcao = question.nextInt();
            question.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("Qual o codigo do seu produto?");
                    if (question.nextLine() == null){
                        System.out.println("Digite algo");
                        break;
                    };
                    String codigoproduto = question.nextLine();

                    System.out.println("Qual nome do seu produto?");
                    if (question.nextLine() == null){
                        System.out.println("Digite algo");
                        break;
                    };
                    String nomeproduto = question.nextLine();


                    System.out.println("Qual a quantidade?");
                    double quantidadeInput = question.nextDouble();
                    question.nextLine();

                    produtoService.cadastrarprodutos(
                            new Produto(codigoproduto, nomeproduto, BigDecimal.valueOf(quantidadeInput))
                    );

                    break;

                case 2:

                    System.out.println("Qual nome do cliente?");
                    if (question.nextLine() == null){
                        System.out.println("Digite algo");
                        break;
                    };
                    String nomecliente = question.nextLine();

                    System.out.println("Qual e a idade do cliente?");
                    if (question.nextLine() == null){
                        System.out.println("Digite algo");
                        break;
                    };
                    int idadeInput = question.nextInt();
                    question.nextLine();

                    System.out.println("Qual e o email do cliente?");
                    if (question.nextLine() == null){
                        System.out.println("Digite algo");
                        break;
                    };
                    String email = question.nextLine();

                    clienteService.cadastrarclientes(
                            new Cliente(nomecliente, email, BigDecimal.valueOf(idadeInput))
                    );
                    break;

                case 3:

                    System.out.println("Qual o nome do cliente?");
                    String nomepessoa = question.nextLine();

                    boolean encontrou = clienteService.existePorNome(nomepessoa);

                    if (encontrou) {

                        System.out.println("Cliente localizado!");

                        System.out.println("Qual nome do produto?");
                        String produtopedido = question.nextLine();

                        System.out.println("Qual a quantidade?");
                        double quantidadeProdutoInput = question.nextDouble();
                        question.nextLine();

                        Pedido pedido1 = new Pedido(produtopedido, BigDecimal.valueOf(quantidadeProdutoInput));
                        produtoService.venda(pedido1);

                    } else {
                        System.out.println("Cliente não está cadastrado");
                    }

                    break;

                case 4:

                    clienteService.info_clientes();
                    produtoService.infos();

                    break;

                case 5:

                    System.out.println("Digite o email registrado do usuário:");
                    String emails = question.nextLine();

                    clienteService.deletarcliente(emails);

                    break;

                case 6:
                    // futuramente
                    break;

                case 7:
                    contador = 2;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        question.close();
    }
}