import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GestaoEstoque gestaoEstoque = new GestaoEstoque();

        GestaoClientes gestaoClientes = new GestaoClientes();

        Scanner question = new Scanner(System.in);

        try {
            Cliente dyego = new Cliente("Dyego", "Dyegolucas2020@gmail.com", 19);
            gestaoClientes.cadastrarclientes(dyego);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int contador = 0;

        while (contador == 0) {

            System.out.println("--- Sistema de Gestão de Vendas e Estoque ---");

            System.out.println("Bem vindo ao Nosso Sistema.");

            System.out.println("Se deseja cadastrar um novo produto Digite -> 1");

            System.out.println("Se deseja cadastrar um novo cliente Digite -> 2 ");

            System.out.println("Se deseja fazer um pedido Digite -> 3 ");

            System.out.println("Se deseja ver as informações dos Clientes e do Estoque digite -> 4 ");

            System.out.println("Se deseja sair do sistema digite -> 5 ");

            int opcao = question.nextInt();

            question.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("Qual nome do seu produto? ");

                    String nomeproduto = question.nextLine();

                    System.out.println("Qual a quantidade? ");

                    double quantidade = question.nextDouble();

                    question.nextLine();

                    gestaoEstoque.cadastrarprodutos(new Produto(nomeproduto, quantidade));

                    break;

                case 2:

                    System.out.println("Qual nome do cliente? ");

                    String nomecliente = question.nextLine();

                    System.out.print("Qual e a idade do cliente? ");

                    int idades = question.nextInt();

                    question.nextLine();

                    System.out.println("Qual e o email do cliente? ");

                    String email = question.nextLine();

                    Cliente novoCliente = new Cliente(nomecliente, email, idades);

                    gestaoClientes.cadastrarclientes(novoCliente);

                    break;

                case 3:

                    System.out.println("Qual o nome do cliente? ");

                    String nomepessoa = question.nextLine();

                    boolean encontrou = false;

                    for (Cliente c : gestaoClientes.clientes) {

                        if (c.nomecliente.equalsIgnoreCase(nomepessoa)) {

                            System.out.println("Cliente localizado!");

                            System.out.println("Qual nome do produto? ");
                            String produtopedido = question.nextLine();

                            System.out.println("Qual a quantidade? ");
                            double quantidadeproduto = question.nextDouble();
                            question.nextLine();

                            Pedido pedido1 = new Pedido(produtopedido, quantidadeproduto);

                            encontrou = true;
                            gestaoEstoque.venda(pedido1);
                            break;
                        }
                    }
                    if (!encontrou) {
                        System.out.println("Cliente não está cadastrado");
                    }
                    break;

                case 4:
                    gestaoClientes.info_clientes();
                    gestaoEstoque.infos();
                    break;

                case 5:
                    contador = 2;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}