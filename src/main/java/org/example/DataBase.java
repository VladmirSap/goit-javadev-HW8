package org.example;

import org.flywaydb.core.Flyway;

public class DataBase {
    private static Flyway flyway;

    private static final String DB_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public DataBase() {

        flyway = Flyway.configure()
                .dataSource(DB_URL, USER, PASSWORD)
                .locations("filesystem:src/main/resources/db/migration")
                .load();

        flyway.migrate();
        System.out.println("Database successfully initialized and migrated.");
    }

    public Flyway getFlyway() {
        return flyway;
    }
}

