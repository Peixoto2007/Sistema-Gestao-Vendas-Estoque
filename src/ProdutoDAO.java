import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {

    public void inserirproduto (Produto produto)throws SQLException {
    try {
        Connection con = Conexao.conectar();

        System.out.println("Conectou");

        String comandoprincipal = "INSERT INTO Estoque  ( NomeProduto,QuantidadeDisponivel) VALUES ( ? , ? , ? )";

        PreparedStatement insercomando = con.prepareStatement(comandoprincipal);

        System.out.println("Passou pelo comando");

        insercomando.setString(1, produto.CodigoProduto);

        insercomando.setString(2, produto.NomeProduto);

        insercomando.setDouble(3, produto.QuantidadeDisponivel);

        insercomando.executeUpdate();

    }
    catch (SQLException e){

        System.out.println(e.getMessage());

        System.out.println("Seu produto está incompleto");
    }
    };
}
