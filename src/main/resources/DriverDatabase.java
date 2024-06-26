package main.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;

public class DriverDatabase {
    public static Connection getConnection() {
        Connection conn = null;

        try {
            String homePath = System.getProperty("user.home") + File.separator;
            File theDir = new File(homePath + ".mytasks");

            if (!theDir.exists()) {
                theDir.mkdirs();
            }

            String url = "jdbc:sqlite:" + homePath + ".mytasks" + File.separator + "database.db";

            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
