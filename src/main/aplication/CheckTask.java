package main.aplication;

import main.resources.Database;
import picocli.CommandLine;
import main.entities.Task;

@CommandLine.Command(name = "check", description = "mark a task with checked status")
public class CheckTask implements Runnable {
    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "display this help message")
    boolean usageHelpRequested;

    @CommandLine.Option(names = {"-u", "--uncheck"}, description = "uncheck a task")
    boolean uncheckRequest;

    @CommandLine.Parameters(index = "0", description = "task id")
    private static int id;

    public static void main(String[] args) {
        new CommandLine(new CheckTask()).execute(args);
    }

    @Override
    public void run() {
        Task task = Database.getTaskById(id);

        if (task != null) {
            if (uncheckRequest) {
                task.uncheck();
            } else {
                task.check();
            }

            Database.update(task);
        } else {
            System.out.println("this id does not match a valid task");
        }
    }
}
