import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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

    public void deletar (Cliente cliente)throws SQLException{



    }

    public void ver () throws  SQLException{


        String comando = "SELECT * FROM CLiente";
    try {


        Connection conn = Conexao.conectar();

        PreparedStatement stmt = conn.prepareStatement(comando);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){

            

        };



    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }


}
