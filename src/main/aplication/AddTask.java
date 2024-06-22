package main.aplication;

import main.entities.Task;
import main.resources.Database;
import picocli.CommandLine;

@CommandLine.Command(name = "AddTask")
public class AddTask implements Runnable{
    @CommandLine.Option(names = "-t", required = true, description = "task title")
    private static String title;

    @CommandLine.Option(names = "-c", required = true, description = "task content description")
    private static String content;

    public static void main(String[] args) {
        new CommandLine(new AddTask()).execute(args);
    }

    @Override
    public void run() {
        Database.saveTask(new Task(title, content));
    }
}
