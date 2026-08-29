import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {


    private static final String URL =
            "jdbc:mysql://-7.0-/BancodoSistemadeGestao";

    private static final String USUARIO = "l-";

    private static final String SENHA = "-";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(
                URL,
                USUARIO,
                SENHA
        );



    }

}
