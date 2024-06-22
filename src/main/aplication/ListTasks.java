package main.aplication;

import main.entities.Task;
import main.resources.Database;
import picocli.CommandLine;

import java.util.ArrayList;

@CommandLine.Command(name = "ListTasks")
public class ListTasks implements Runnable {
    public static void main(String[] args) {
        new CommandLine(new ListTasks()).execute(args);
    }

    @Override
    public void run() {
        ArrayList<Task> list = Database.getTasks();
        for (Task task : list) {
            System.out.println(task);
        }
    }
}
