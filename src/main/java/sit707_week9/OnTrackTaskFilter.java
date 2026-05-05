package sit707_week9;

import java.util.ArrayList;
import java.util.List;

/**
 * Simplified OnTrack task filtering function.
 * 
 * This class filters OnTrack tasks based on the student's selected target grade.
 */
public class OnTrackTaskFilter {

    private List<Task> allTasks;

    public OnTrackTaskFilter() {
        allTasks = new ArrayList<>();

        // Sample OnTrack tasks based on different grade levels.
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
     * Returns tasks that are required for the selected target grade.
     */
    public List<Task> getTasksForTargetGrade(String targetGrade) {
        validateTargetGrade(targetGrade);

        List<Task> filteredTasks = new ArrayList<>();

        for (Task task : allTasks) {
            if (getGradeRank(task.getGradeLevel()) <= getGradeRank(targetGrade)) {
                filteredTasks.add(task);
            }
        }

        return filteredTasks;
    }

    /**
     * Checks whether the selected target grade is valid.
     */
    private void validateTargetGrade(String targetGrade) {
        if (targetGrade == null || targetGrade.trim().isEmpty()) {
            throw new IllegalArgumentException("Target grade cannot be empty");
        }

        if (getGradeRank(targetGrade) == -1) {
            throw new IllegalArgumentException("Invalid target grade");
        }
    }

    /**
     * Gives each grade level a rank.
     * 
     * Lower ranked tasks are included when a higher target grade is selected.
     */
    private int getGradeRank(String gradeLevel) {
        if (gradeLevel.equals("Pass")) {
            return 1;
        }

        if (gradeLevel.equals("Credit")) {
            return 2;
        }

        if (gradeLevel.equals("Distinction")) {
            return 3;
        }

        if (gradeLevel.equals("High Distinction")) {
            return 4;
        }

        return -1;
    }
}