package org.example;

import org.flywaydb.core.Flyway;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DatabaseQueryService {
    private final Flyway flyway;

    public DatabaseQueryService(Flyway flyway) {
        this.flyway = flyway;
    }

    private String readSqlFile(String filePath) throws IOException {
        StringBuilder sql = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sql.append(line).append("\n");
            }
        }
        return sql.toString();
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        String sqlFilePath = "sql/find_max_projects_client.sql";
        return executeQuery(sqlFilePath, resultSet -> {
            try {
                String name = resultSet.getString("name");
                int projectCount = resultSet.getInt("project_count");
                return new MaxProjectCountClient(name, projectCount);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    public List<LongestProject> findLongestProject() {
        String sqlFilePath = "sql/find_longest_project.sql";
        return executeQuery(sqlFilePath, resultSet -> {
            try {
                String projectName = resultSet.getString("id");
                int longestDuration = resultSet.getInt("month_count");
                return new LongestProject(projectName, longestDuration);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        String sqlFilePath = "sql/find_max_salary_worker.sql";
        return executeQuery(sqlFilePath, resultSet -> {
            try {
                String workerName = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                return new MaxSalaryWorker(workerName, salary);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    public List<YoungestEldestWorker> findYoungestEldestWorker() {
        String sqlFilePath = "sql/find_youngest_eldest_workers.sql";
        return executeQuery(sqlFilePath, resultSet -> {
            try {
                String type = resultSet.getString("type");
                String workerName = resultSet.getString("name");
                LocalDate birthday = LocalDate.parse(resultSet.getString("birthday"));
                return new YoungestEldestWorker(type, workerName, birthday);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    private <T> List<T> executeQuery(String sqlFilePath, Function<ResultSet, T> mapper) {
        List<T> result = new ArrayList<>();
        String sql = null;

        try (Connection connection = flyway.getConfiguration().getDataSource().getConnection()) {
            sql = readSqlFile(sqlFilePath);
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    T mappedResult = mapper.apply(resultSet);
                    if (mappedResult != null) {
                        result.add(mappedResult);
                    }
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}

