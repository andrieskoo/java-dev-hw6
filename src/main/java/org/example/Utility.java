package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utility {
    private static Logger loger = LogManager.getLogger(Utility.class);
    private static Statement statement;

    static String readFromFileQuery(String sqlFilePath) throws FileNotFoundException {
        try (InputStream inputStream = DatabaseInitService.class.getClassLoader().getResourceAsStream(sqlFilePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line =reader.readLine())!=null)
            {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();
        } catch(Exception e) {
            loger.error("Cannot read script from file");
            throw new FileNotFoundException();
        }
    }

    static void executeQuery(Connection connection, String query) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
            loger.info("Query were executed successful");
            System.out.println("YRA");
        } catch (SQLException e) {
            loger.error("Error while execute sql statement");
            throw new RuntimeException(e);
        }
    }

    static ResultSet executeResultQuery(Connection connection, String query) {
        try {
            Statement statement = connection.createStatement();
            loger.info("Query were executed successful");
            return statement.executeQuery(query);

        } catch (SQLException e) {
            loger.error("Error while execute sql statement");
            throw new RuntimeException(e);
        }
    }
    static void closeConnection(){
        try {
            Database.getInstance().getConnection().close();
            loger.info("Database connection was closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}