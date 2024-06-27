package main.entities;

import picocli.CommandLine;
import java.util.Date;

public class Task {
    private int id;
    private String title;
    private String content;
    private boolean checked;
    private Date date;

    public Task(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.checked = false;
        this.date = new Date();
    }

    public Task(int id, String title, String content, boolean checked, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.checked = checked;
        this.date = date;
    }

    public Task(String title, String content) {
        this.title = title;
        this.content = content;
        this.checked = false;
        this.date = new Date();
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

    public Date getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return id + " " + title.toUpperCase() + " " + content;
    }
}
