package main.aplication;

import main.entities.Task;
import main.resources.Database;
import picocli.CommandLine;

@CommandLine.Command(name = "add", description = "add a task in the database")
public class AddTask implements Runnable {
    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "display this help message")
    boolean usageHelpRequested;

    @CommandLine.Option(names = "-t", required = true, description = "task title")
    private static String title;

    @CommandLine.Option(names = "-c", description = "task content description")
    private static String content;

    public static void main(String[] args) {
        new CommandLine(new AddTask()).execute(args);
    }

    @Override
    public void run() {
        if (content == null) {
            content = "";
        }

        Database.saveTask(new Task(title, content));
    }
}
