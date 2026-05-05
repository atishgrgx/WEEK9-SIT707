package sit707_week9;

/**
 * Represents a simple OnTrack task.
 */
public class Task {

    private String taskId;
    private String title;
    private String gradeLevel;

    public Task(String taskId, String title, String gradeLevel) {
        this.taskId = taskId;
        this.title = title;
        this.gradeLevel = gradeLevel;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }
}
