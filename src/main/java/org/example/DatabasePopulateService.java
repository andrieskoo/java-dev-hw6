package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.sql.Connection;

import static org.example.Utility.executeQuery;
import static org.example.Utility.readFromFileQuery;

public class DatabasePopulateService {
    private  static final Logger loger = LogManager.getLogger(DatabasePopulateService.class);

    public static void main(String[] args) {
        Connection connection = Database.getInstance().getConnection();

        String sqlFilePath = "sql/populate_db.sql";

        try {
            String query = readFromFileQuery(sqlFilePath);
            executeQuery(connection, query);

        } catch (FileNotFoundException ex) {
            loger.error("Can't find file with sql statement");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
