package main.aplication;

import main.entities.Task;
import main.resources.Database;
import picocli.CommandLine;

import java.time.LocalDate;
import java.util.ArrayList;

@CommandLine.Command(name = "ls", description = "list tasks")
public class ListTasks implements Runnable {
    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "display this help message")
    boolean usageHelpRequested;

    @CommandLine.Option(names = {"-a", "--all"}, description = "list all tasks including checked tasks")
    boolean usageCheckedTasksRequested;

    @CommandLine.Option(names = {"-d", "--date"}, description = "print task created date")
    boolean usageDateResquested;

    public static void main(String[] args) {
        new CommandLine(new ListTasks()).execute(args);
    }

    @Override
    public void run() {
        ArrayList<Task> list = Database.getTasks();

        // -a or --all
        if (usageCheckedTasksRequested) {
            for (Task task : list) {
                if (task.checked()) {
                    // -d or --date
                    if (usageDateResquested) printDate(task.getDate(), true);
                    printTask(task.toString(), true);
                }
            }
        }

        for (Task task : list) {
            if (!task.checked()) {
                // -d or --date
                if (usageDateResquested) printDate(task.getDate(), false);
                printTask(task.toString(), false);
            }
        }
    }

    private static void printDate(LocalDate date, boolean faint) {
        if (faint) System.out.print(CommandLine.Help.Ansi.AUTO.string("@|faint " + date.getDayOfMonth() + "/" + date.getMonth() + "/" + (date.getYear()) + " " + "|@"));
        else System.out.print(date.getDayOfMonth() + "/" + date.getMonth() + "/" + (date.getYear()) + " ");
    }

    private static void printTask(String task, boolean faint) {
        if (faint) System.out.println(CommandLine.Help.Ansi.AUTO.string("@|faint " + task + "|@"));
        else System.out.println(task);
    }
}
