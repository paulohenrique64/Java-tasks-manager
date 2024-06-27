package main.aplication;

import main.resources.Database;
import picocli.CommandLine;

@CommandLine.Command(name = "mytask", mixinStandardHelpOptions = true,  version = "mytask 1.0",
        description = "A simple CLI aplication for store user tasks")
public class MyTask implements Runnable {
    public static void main(String[] args) {
        MyTask app = new MyTask();

        new CommandLine(app)
                .addSubcommand("add", new AddTask())
                .addSubcommand("ls", new ListTasks())
                .addSubcommand("rm", new RemoveTask())
                .addSubcommand("check", new CheckTask())
                .setExecutionStrategy(app::executionStrategy)
                .execute(args);
    }

    private int executionStrategy(CommandLine.ParseResult parseResult) {
        run();
        return new CommandLine.RunLast().execute(parseResult);
    }

    @Override
    public void run() {
        // create the tasks table if not exists
        Database.createTasksTable();
    }
}
