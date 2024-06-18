package paulo.project.aplication;

import paulo.project.entities.Task;
import paulo.project.resources.Database;
import paulo.project.resources.DriverDatabase;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;  // Import the Scanner class

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static int option;

    public static void main(String[] args) {
        // WARNING
        // Database.deleteTasksTable();

        // create the tasks table if not exists
        Database.createTasksTable();

        do {
            printMenu();

            switch (option) {
                case 1: {
                    String title, content;
                    sc.nextLine();
                    System.out.print("title: "); title = sc.nextLine();
                    System.out.print("content: "); content = sc.nextLine();
                    Database.saveTask(new Task(title, content));
                    break;
                }
                case 2: {
                    int id;
                    String title, content;
                    System.out.print("id: "); id = sc.nextInt();
                    sc.nextLine(); System.out.print("title: "); title = sc.nextLine();
                    System.out.print("content: "); content = sc.nextLine();
                    Database.editTask(new Task(id, title, content));
                    break;
                }
                case 3: {
                    ArrayList<Task> list = Database.getTasks();
                    for (Task task : list) {
                        System.out.println(task);
                    }
                    break;
                }
                case 4: {
                    System.out.print("id: ");
                    int id = sc.nextInt();
                    Database.deleteTask(id);
                    break;
                }
                default:
                    break;
            }
        } while (option != 0);

        sc.close();
    }

    public static void printMenu() {
        try {
            Runtime.getRuntime().exec("clear");
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("my tasks\n");
        System.out.println("1 - add new task");
        System.out.println("2 - edit tasks");
        System.out.println("3 - show tasks");
        System.out.println("4 - delete tasks");
        System.out.println("0 - quit\n");
        System.out.println("enter your option: ");

        option = sc.nextInt();
    }
}

