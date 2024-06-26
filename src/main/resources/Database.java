package main.resources;

import main.entities.Task;
import java.sql.*;
import java.util.ArrayList;

public class Database {
    public static void createTasksTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS tasks ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "title TEXT NOT NULL, "
                + "content TEXT, "
                + "checked BOOLEAN NOT NULL"
                + ");";

        Connection conn = DriverDatabase.getConnection();

        try {
            var stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void deleteTasksTable() {
        // SQL statement for delete the tasks table
        String sql = "DROP TABLE tasks";

        Connection conn = DriverDatabase.getConnection();

        try {
            var stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void saveTask(Task task) {
        // SQL statement for save task on tasks table
        String sql = "INSERT INTO tasks "
                + "(title, content, checked) "
                + "VALUES ('"
                + task.getTitle()
                + "','"
                + task.getContent()
                + "','"
                + task.isChecked()
                + "');";

        Connection conn = DriverDatabase.getConnection();

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Task getTaskById(int id) {
        // SQL statement for save task on tasks table
        String sql = "SELECT * FROM tasks WHERE tasks.id = "
                + id
                + ";";

        Connection conn = DriverDatabase.getConnection();

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            return new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return null;
    }

    public static void update(Task task) {
        int boolValue = 0;

        if (task.isChecked()) {
            boolValue = 1;
        }

        // SQL statement for edit task on tasks table
        String sql = "UPDATE tasks SET "
                + "title = '"
                + task.getTitle()
                + "', content = '"
                + task.getContent()
                + "', checked = '"
                + boolValue
                + "' WHERE tasks.id = "
                + task.getId()
                + ";";

        Connection conn = DriverDatabase.getConnection();

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static ArrayList<Task> getTasks() {
        ArrayList<Task> list = new ArrayList<>();

        // SQL statement for get all tasks from tasks table
        String sql = "SELECT * FROM tasks;";

        Connection conn = DriverDatabase.getConnection();

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                list.add(new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return list;
    }

    public static void deleteTask(int id) {
        // SQL statement for delete task for the tasks table
        String sql = "DELETE FROM tasks WHERE tasks.id = " + id + ";";

        Connection conn = DriverDatabase.getConnection();

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
