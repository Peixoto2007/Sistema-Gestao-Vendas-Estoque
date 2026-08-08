import java.util.ArrayList;

public class GestaoClientes {
    ArrayList<Cliente>clientes = new ArrayList<>();

    public void cadastrarclientes(Cliente cliente){

        System.out.println("---- Novo Cliente para Cadastro ----");

        clientes.addLast(cliente);

        System.out.println(cliente.nomecliente);}

///colocar numero de vendas por clientes

    public void info_clientes(){

        System.out.println("--- Informações dos Clientes ---");

        for (Cliente c : clientes ){

        c.info();

        };
    };
}


