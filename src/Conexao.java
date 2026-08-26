import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {


    private static final String URL =
            "jdbc:mysql://***7.0.0-----/?use-";

    private static final String USUARIO = "--";

    private static final String SENHA = "---";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(
                URL,
                USUARIO,
                SENHA
        );
    }

}
