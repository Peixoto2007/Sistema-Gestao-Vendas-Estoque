import java.sql.SQLException;
import java.util.ArrayList;


public class GestaoClientes {

    ArrayList<Cliente>clientes = new ArrayList<>();

    private final ClienteDAO dao = new ClienteDAO();


    public void cadastrarclientes(Cliente cliente) {

        try {
            System.out.println("---- Novo Cliente para Cadastro ----");

            clientes.addLast(cliente);
            dao.inserir(cliente);

            System.out.println(cliente.nomecliente);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
    }


        }
    public void deletarcliente (String email){

    try {

        dao.deletar(email);

        clientes.removeIf(c -> c.email.equalsIgnoreCase(email));

    }
    catch (SQLException e){

        throw new RuntimeException(e);

    }
}
    public void info_clientes(){

        System.out.println("--- Informações dos Clientes ---");

        for (Cliente c : clientes ){

            c.info();

        }
    }
}
