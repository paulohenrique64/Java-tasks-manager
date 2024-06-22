package main.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverDatabase {
    public static Connection getConnection() {
        Connection conn = null;

        try {
            String url = "jdbc:sqlite:C:tasks-database.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
