import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ClienteDAO {

    public void inserir (Cliente cliente) throws SQLException{

        try {

            Connection conn = Conexao.conectar();

            System.out.println("Conectou");

            String comandoadd = "INSERT INTO Cliente (NomeCliente , Email , Idade ) VALUES (?,?,?)";

            System.out.println("Passou pelo comando");

            PreparedStatement stmt = conn.prepareStatement(comandoadd);

            System.out.println("Passou pelo preapred");

            stmt.setString(1,cliente.nomecliente);

            stmt.setString(2,cliente.email);

            stmt.setInt(3,cliente.idade);

            stmt.executeUpdate();

            System.out.println("Cliente Salvo com sucesso");

        }
        catch (SQLException e) {

            System.out.println(e.getMessage());

            System.out.println("Cliente não foi salvo");

        }
    }

    public void deletar (String email)throws SQLException{

        try{
    String comandodelete = "DELETE FROM Cliente where Email = ?";


    Connection conn = Conexao.conectar();
    PreparedStatement stmt = conn.prepareStatement(comandodelete);
        stmt.setString(1,email);

        stmt.executeUpdate();

        System.out.println("Cliente excluido");

        conn.close();

        }

        catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Cliente não foi excluido");
        }
    }

    public void ver () throws  SQLException{


        String comando = "SELECT NomeCliente, Email, Idade FROM Cliente";

        try {


        Connection conn = Conexao.conectar();

        PreparedStatement stmt = conn.prepareStatement(comando);

        ResultSet rs = stmt.executeQuery();

        boolean temCliente = false;

        while (rs.next()) {

            temCliente = true;

            String nome = rs.getString("NomeCliente");

            String email = rs.getString("Email");
            
            int idade = rs.getInt("Idade");

            System.out.println("Nome: " + nome);
            System.out.println("Email: " + email);
            System.out.println("Idade: " + idade);
            System.out.println("-----------------------------");
        }

        if (!temCliente) {
            System.out.println("Nenhum cliente encontrado.");
        }

    } catch (SQLException e) {
        System.out.println(e.getMessage());
        System.out.println("Não foi possível consultar os clientes");
    }
    }


}
