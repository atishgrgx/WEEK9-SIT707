package sit707_week9;

/**
 * Represents a simple OnTrack task.
 */
public class Task {

    private String id;
    private String title;
    private String grade;

    public Task(String id, String title, String grade) {
        this.id = id;
        this.title = title;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGrade() {
        return grade;
    }
}
