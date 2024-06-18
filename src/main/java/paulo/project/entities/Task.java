package paulo.project.entities;

public class Task {
    private int id;
    private String title;
    private String content;

    public Task(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Task(String title, String content) {
        this.title = title;
        this.content = content;
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + id + " title: " + title + " content: " + content;
    }
}
