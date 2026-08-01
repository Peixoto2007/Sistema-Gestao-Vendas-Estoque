import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        GestaoEstoque gestaoEstoque = new GestaoEstoque();
        GestaoClientes gestaoClientes = new GestaoClientes();

        System.out.println("--- Sistema de Gestão de Vendas e Estoque ---");

        Scanner question = new Scanner(System.in);
        System.out.println("Bem vindo ao Nosso Sistema.");
        System.out.println("Se deseja cadastrar um novo produto Digite -> 1");
        System.out.println("Se deseja cadastrar um novo cliente Digite -> 2 ");
        System.out.println("Se deseja fazer um pedido Digite -> 3 ");

        int opcao = question.nextInt();

        switch (opcao){

            case 1 :
                Scanner questioncadastroproduto = new Scanner(System.in);
                System.out.println("Qual nome do seu produto e Quantidade ");
                String nomeproduto = questioncadastroproduto.next();
                double quantidade = questioncadastroproduto.nextDouble();
                gestaoEstoque.cadastrarprodutos(new Produto(nomeproduto,quantidade));

            case 2 :
                Scanner questioncadastrocliente = new Scanner(System.in);
                System.out.println("Qual nome do cliente ");
                System.out.println("Qual e o cpf do cliente ");
                System.out.println("Qual e o email do cliente ");
                String nomecliente = questioncadastrocliente.next();
                String cpf = questioncadastrocliente.next();
                String email = questioncadastrocliente.next();
                gestaoClientes.cadastrarclientes(new Cliente(nomecliente,cpf,email));

        };




        gestaoClientes.info_clientes();
        gestaoEstoque.infos();










        }
    }