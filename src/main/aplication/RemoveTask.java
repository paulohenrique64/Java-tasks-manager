package main.aplication;

import main.entities.Task;
import main.resources.Database;
import picocli.CommandLine;

import java.util.ArrayList;

@CommandLine.Command(name = "rm", description = "remove a selected task")
public class RemoveTask implements Runnable {
    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "display this help message")
    boolean usageHelpRequested;

    @CommandLine.Parameters(index = "0", description = "task id")
    private static int id;

    public static void main(String[] args) {
        new CommandLine(new RemoveTask()).execute(args);
    }

    @Override
    public void run() {
        Database.deleteTask(id);
    }
}
