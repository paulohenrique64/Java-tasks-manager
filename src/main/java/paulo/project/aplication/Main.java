package paulo.project.aplication;

import java.util.Scanner;  // Import the Scanner class

public class Main {
    public static void main(String[] args) {
        Integer option;

        do {
            option = printMenu();

            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        } while (option != 0);
    }

    public static Integer printMenu() {
        Scanner sc = new Scanner(System.in);

        try {
            Runtime.getRuntime().exec("cls && clear");
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("my tasks - CRUD BASE\n");
        System.out.println("1 - add new task");
        System.out.println("2 - edit tasks");
        System.out.println("3 - show tasks");
        System.out.println("4 - delete tasks");
        System.out.println("0 - quit\n");
        System.out.println("enter your option: ");
        return sc.nextInt();
    }
}

