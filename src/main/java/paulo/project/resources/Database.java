package paulo.project.resources;

import com.sun.jdi.connect.spi.ClosedConnectionException;
import paulo.project.entities.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static void createTasksTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS tasks ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "title TEXT NOT NULL, "
                + "content TEXT"
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
                + "(title, content) "
                + "VALUES ('"
                + task.getTitle()
                + "','"
                + task.getContent()
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

    public static void editTask(Task task) {
        // SQL statement for edit task on tasks table
        String sql = "UPDATE tasks SET "
                + "title = '"
                + task.getTitle()
                + "', content = '"
                + task.getContent()
                + "' WHERE tasks.id = "
                + task.getId()
                + ";";

        System.out.println(sql);

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
                list.add(new Task(rs.getInt(1), rs.getString(2), rs.getString(3)));
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
