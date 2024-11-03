package br.com.fiap.fintech.factory;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    static Dotenv dotenv = Dotenv.configure().load();

    static String url = dotenv.get("DATABASE_URL");
    static String usuario = dotenv.get("DATABASE_USUARIO");
    static String senha = dotenv.get("DATABASE_SENHA");


    private static final String URL = url;
    private static final String USUARIO = usuario;
    private static final String SENHA = senha;

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC não encontrado.", e);
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}

