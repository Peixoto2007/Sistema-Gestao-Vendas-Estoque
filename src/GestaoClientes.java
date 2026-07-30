import java.util.ArrayList;

public class GestaoClientes {
    ArrayList<Cliente>clientes = new ArrayList<>();

    public void cadastrarclientes(Cliente cliente){
        System.out.println("---- Novo Cliente para Cadastro ----");
        clientes.add(cliente);}

    public void info_clientes(){
        System.out.println("--- Iformações dos Clientes ---");
        for (Cliente c : clientes ){

        c.info();

        };
    };
}


