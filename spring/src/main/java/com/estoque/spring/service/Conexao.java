package com.estoque.spring.model;

public class Conexao {


    private static final String URL =

            "jdbc:mysql://127.0.0.1:3306/BancodoSistemadeGestao";

    private static final String USUARIO = "root";

    private static final String SENHA = "123456";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(
                URL,
                USUARIO,
                SENHA
        );



    }

}
