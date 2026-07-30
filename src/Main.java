//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("--- Sistema de Gestão de Vendas e Estoque ---");

        Cliente dyego = new Cliente("Dyego Alves","70950230630","Dyegoluca552@gmail.com");
        Cliente lucas = new Cliente("Lucas ","75050230630","luca552@gmail.com");

        dyego.info();
        lucas.info();

        GestaoClientes gestaoClientes = new GestaoClientes();

        gestaoClientes.cadastrarclientes(dyego);
        gestaoClientes.cadastrarclientes(lucas);
        gestaoClientes.info_clientes();










        }
    }