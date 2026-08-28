import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    try {
        Connection conexao = Conexao.conectar();
        {
            System.out.println("Conectado ");
        };
    }

    catch(SQLException e){
        System.out.println("NÃO Conectado ");
        System.out.println(e.getMessage());
    }


        GestaoEstoque gestaoEstoque = new GestaoEstoque();
        GestaoClientes gestaoClientes = new GestaoClientes();
        int contador = 0 ;
        while (contador == 0){


            System.out.println("--- Sistema de Gestão de Vendas e Estoque ---");
            Scanner question = new Scanner(System.in);
            System.out.println("Bem vindo ao Nosso Sistema.");

            System.out.println("Se deseja cadastrar um novo produto Digite -> 1");

            System.out.println("Se deseja cadastrar um novo cliente Digite -> 2 ");

            System.out.println("Se deseja fazer um pedido Digite -> 3 ");

            System.out.println("Se deseja ver as informações dos Clientes e do Estoque digite -> 4 ");

            System.out.println("Se deseja sair do sistema digite -> 5 ");

            int opcao = question.nextInt();

            switch (opcao) {

                case 1:
                    Scanner questioncadastroproduto = new Scanner(System.in);

                    System.out.println("Qual nome do seu produto e Quantidade ");

                    String nomeproduto = questioncadastroproduto.nextLine();

                    double quantidade = questioncadastroproduto.nextDouble();

                    gestaoEstoque.cadastrarprodutos(new Produto(nomeproduto, quantidade));

                    break;

                case 2:
                    Scanner questioncadastrocliente = new Scanner(System.in);

                    System.out.println("Qual nome do cliente ");

                    String nomecliente = questioncadastrocliente.nextLine();

                    System.out.print("Qual e a idade do cliente ");

                    int idade = questioncadastrocliente.nextLine();

                    System.out.println("Qual e o email do cliente ");

                    String email = questioncadastrocliente.nextLine();




                    gestaoClientes.cadastrarclientes(new Cliente(nomecliente, idade, email));

                    break;

                case 3:
                    Scanner pergunta_pedido = new Scanner(System.in);

                    System.out.println("Qual e o cpf do cliente ");


                    String cpfpessoa = pergunta_pedido.nextLine();

                    boolean encontrou = false;

                        for (Cliente c : gestaoClientes.clientes) {

                            if (c.getCpf().equals(cpfpessoa)) {

                                System.out.println("CPF localizado no banco de dados");

                                System.out.println("Qual nome do produto ? ");

                                System.out.println("Qual a Quantidade ? ");

                                String produtopedido = pergunta_pedido.nextLine();

                                double quantidadeproduto = pergunta_pedido.nextDouble();

                                Pedido pedido1 = new Pedido(produtopedido, quantidadeproduto);
                                
                                encontrou = true;

                                gestaoEstoque.venda(pedido1);
                                break;

                            }

                        }
                        if (!encontrou){
                            System.out.println("O Cpf não está cadastrado");
                        }
                        break;
                case 4 : gestaoClientes.info_clientes();
                    gestaoEstoque.infos();

                case 5 : contador = 2;
            }

    }











        }
    }