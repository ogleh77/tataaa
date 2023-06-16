package com.example.gymmanagement.dependencies;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DbConnection {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:src/database/data.db");
            }
        } catch (Exception e) {
            // Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
           // alert.showAndWait();
            e.printStackTrace();
        }
        return connection;
    }
}
