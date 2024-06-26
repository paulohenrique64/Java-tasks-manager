package main.aplication;

import main.resources.Database;
import picocli.CommandLine;
import main.entities.Task;

public class CheckTask implements Runnable {
    @CommandLine.Parameters(index = "0")
    private static int id;

    public static void main(String[] args) {
        new CommandLine(new CheckTask()).execute(args);
    }

    @Override
    public void run() {
        Task task = Database.getTaskById(id);
        task.check();
        Database.update(task);
    }
}
