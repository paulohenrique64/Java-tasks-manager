package main.aplication;

import main.resources.Database;
import picocli.CommandLine;

@CommandLine.Command(name = "MyTasks", subcommands = {AddTask.class, ListTasks.class})
public class MyTasks implements Runnable {
    public static void main(String[] args) {
        MyTasks app = new MyTasks();

        new CommandLine(app)
                .addSubcommand("add", new AddTask())
                .addSubcommand("ls", new ListTasks())
                .setExecutionStrategy(app::executionStrategy)
                .execute(args);
    }

    private int executionStrategy(CommandLine.ParseResult parseResult) {
        run();
        return new CommandLine.RunLast().execute(parseResult);
    }


    @Override
    public void run() {
        // WARNING
        // Database.deleteTasksTable();

        // create the tasks table if not exists
        Database.createTasksTable();
    }
}
