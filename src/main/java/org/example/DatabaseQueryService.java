package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.DTO.LongestProject;
import org.example.DTO.MaxProjectCountClient;
import org.example.DTO.MaxSalaryWorker;
import org.example.DTO.YoungestEldestWorkers;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.Utility.*;

public class DatabaseQueryService {
 private static final Logger loger = LogManager.getLogger(DatabaseQueryService.class);

    public static void main(String[] args) {
        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
        loger.info(maxProjectCountClients);

        List<LongestProject> longestProjects = new DatabaseQueryService().findLongestProject();
        loger.info(longestProjects);

        List<MaxSalaryWorker> maxSalaryWorkers = new DatabaseQueryService().findMaxSalaryWorker();
        loger.info(maxSalaryWorkers);

        List<YoungestEldestWorkers> youngestEldestWorker = new DatabaseQueryService().findYoungestEldestWorker();
        loger.info(youngestEldestWorker);
    }

    private List<MaxProjectCountClient> findMaxProjectsClient() {
        Connection connection = Database.getInstance().getConnection();

        String sqlFilePath = "sql/find_max_projects_client.sql";
        List<MaxProjectCountClient> resultList = new ArrayList<>();
        try {
            String query = readFromFileQuery(sqlFilePath);
            ResultSet resultSet = executeResultQuery(connection, query);
            while (resultSet.next()){
                MaxProjectCountClient item = new MaxProjectCountClient();
                item.setName(resultSet.getString("name"));
                item.setProjectCount(resultSet.getInt("project_quantity"));
                resultList.add(item);
            }
        } catch (FileNotFoundException ex) {
            loger.error("Can't find file with sql statement");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    private List<LongestProject> findLongestProject() {
        Connection connection = Database.getInstance().getConnection();

        String sqlFilePath = "sql/find_longest_project.sql";
        List<LongestProject> resultList = new ArrayList<>();
        try {
            String query = readFromFileQuery(sqlFilePath);
            ResultSet resultSet = executeResultQuery(connection, query);
            while (resultSet.next()){
                LongestProject item = new LongestProject();
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                item.setDuration(resultSet.getInt("mouth_duration"));
                resultList.add(item);
            }
        } catch (FileNotFoundException ex) {
            loger.error("Can't find file with sql statement");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    private List<MaxSalaryWorker> findMaxSalaryWorker() {
        Connection connection = Database.getInstance().getConnection();

        String sqlFilePath = "sql/find_max_salary_worker.sql";
        List<MaxSalaryWorker> resultList = new ArrayList<>();
        try {
            String query = readFromFileQuery(sqlFilePath);
            ResultSet resultSet = executeResultQuery(connection, query);
            while (resultSet.next()){
                MaxSalaryWorker item = new MaxSalaryWorker();
                item.setName(resultSet.getString("name"));
                item.setSalary(resultSet.getInt("salary"));
                resultList.add(item);
            }
        } catch (FileNotFoundException ex) {
            loger.error("Can't find file with sql statement");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    private List<YoungestEldestWorkers> findYoungestEldestWorker() {
        Connection connection = Database.getInstance().getConnection();

        String sqlFilePath = "sql/find_youngest_eldest_workers.sql";
        List<YoungestEldestWorkers> resultList = new ArrayList<>();
        try {
            String query = readFromFileQuery(sqlFilePath);
            ResultSet resultSet = executeResultQuery(connection, query);
            while (resultSet.next()){
                YoungestEldestWorkers item = new YoungestEldestWorkers();
                item.setId(resultSet.getInt("id"));
                item.setType(resultSet.getString("type"));
                item.setName(resultSet.getString("name"));
                item.setBirthday(LocalDate.parse(resultSet.getString("birthday")));
                resultList.add(item);
            }
        } catch (FileNotFoundException ex) {
            loger.error("Can't find file with sql statement");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

}
