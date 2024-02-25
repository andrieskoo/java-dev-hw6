package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Database {

    private String URL = "jdbc:h2:~/test";
    private String user = "sa";
    private String password;

    private static Database instance;

    private final Connection connection;

    private Database() {

        try {
            connection = DriverManager.getConnection(URL, user, password);
//            Statement stm = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Database getInstance() {
        return Objects.requireNonNullElseGet(instance, Database::new);
    }

    public Connection getConnection() {
        return connection;
    }

    public void close(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
