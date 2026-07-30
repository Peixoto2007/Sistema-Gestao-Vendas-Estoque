import java.util.ArrayList;

public class GestaoClientes {
    ArrayList<Cliente>clientes = new ArrayList<>();

    private void cadastrarclientes(Cliente cliente){
        System.out.println("---- Novo Cliente para Cadastro ----");
        clientes.add(cliente);

    };
}
