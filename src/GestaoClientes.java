import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class GestaoClientes {
    ArrayList<Cliente>clientes = new ArrayList<>();




    public void cadastrarclientes(Cliente cliente){
        try {
            Connection conn = Conexao.conectar();

            String comandoadd = "INSERT INTO Cliente (NomeCliente , Email , Idade ) VALUES (?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(comandoadd);

            stmt.setString(1,cliente.nomecliente);
            stmt.setString(2,cliente.email);
            stmt.setInt(3,cliente.idade);

            stmt.executeUpdate();
            System.out.println("Cliente Salvo com sucesso");

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Clientenão foi salvo");
        };





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


