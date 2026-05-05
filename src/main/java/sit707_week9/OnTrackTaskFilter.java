package sit707_week9;

import java.util.ArrayList;
import java.util.List;

/**
 * Simplified OnTrack task filtering function.
 * 
 * This class filters tasks based on the target grade selected by the student.
 */
public class OnTrackTaskFilter {

    private List<Task> allTasks;

    public OnTrackTaskFilter() {
        allTasks = new ArrayList<>();

        // Sample OnTrack tasks for testing the filtering function.
        allTasks.add(new Task("1.1P", "Evidence week 1 learning", "Pass"));
        allTasks.add(new Task("1.2P", "Browser automation using Selenium", "Pass"));
        allTasks.add(new Task("2.1P", "Selenium test case", "Pass"));

        allTasks.add(new Task("3.2C", "Equivalence class test case", "Credit"));
        allTasks.add(new Task("4.2C", "Decision table tests with Selenium", "Credit"));

        allTasks.add(new Task("6.2D", "Right-BICEP and code coverage", "Distinction"));
        allTasks.add(new Task("3.3D", "Recommendation for 3.2C", "Distinction"));

        allTasks.add(new Task("7.2H", "CI/CD with Google Cloud Platform", "High Distinction"));
    }

    /**
     * Returns the list of tasks required for the selected target grade.
     */
    public List<Task> getTasksForTargetGrade(String targetGrade) {
        if (targetGrade == null || targetGrade.trim().isEmpty()) {
            throw new IllegalArgumentException("Target grade cannot be empty");
        }

        List<Task> filteredTasks = new ArrayList<>();

        for (Task task : allTasks) {
            if (shouldShowTask(targetGrade, task.getGradeLevel())) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    /**
     * Checks whether a task should be shown for the selected target grade.
     */
    private boolean shouldShowTask(String targetGrade, String taskGrade) {
        if (targetGrade.equals("Pass")) {
            return taskGrade.equals("Pass");
        }

        if (targetGrade.equals("Credit")) {
            return taskGrade.equals("Pass") || taskGrade.equals("Credit");
        }

        if (targetGrade.equals("Distinction")) {
            return taskGrade.equals("Pass") || taskGrade.equals("Credit") || taskGrade.equals("Distinction");
        }

        if (targetGrade.equals("High Distinction")) {
            return taskGrade.equals("Pass") || taskGrade.equals("Credit") || taskGrade.equals("Distinction") || taskGrade.equals("High Distinction");
        }

        return false;
    }
}