package main.entities;

import picocli.CommandLine;

import java.time.LocalDate;
import java.util.Date;

public class Task {
    private int id;
    private String title;
    private String content;
    private boolean checked;
    private LocalDate date;

    public Task(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.checked = false;
        this.date = LocalDate.now();
    }

    public Task(int id, String title, String content, boolean checked, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.checked = checked;
        this.date = LocalDate.now();
    }

    public Task(String title, String content) {
        this.title = title;
        this.content = content;
        this.checked = false;
        this.date = LocalDate.now();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void check() {
        this.checked = true;
    }

    public void uncheck() {
        this.checked = false;
    }

    public boolean checked() {
        return this.checked;
    }

    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return id + " " + title.toUpperCase() + " " + content;
    }
}
