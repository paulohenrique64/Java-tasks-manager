### java-tasks-manager

Simple java CLI application for manage and storage user tasks

### Techs used

* sqlite
* picocli

### Usage

Run `make build` to compile and create the aplication `.jar` file

Executing `java -jar mytask.jar -h` in terminal:

```
Usage: mytask [-hV] [COMMAND]
A simple CLI aplication for store user tasks
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
Commands:
  add    add a task in the database
  ls     list tasks
  rm     remove a selected task
  check  mark a task with checked status
```

- The database will storage in the path:<br>`<user home directory>/.mytaks/database.db`

