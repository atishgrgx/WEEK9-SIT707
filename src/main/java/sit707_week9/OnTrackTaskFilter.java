package sit707_week9;

import java.util.ArrayList;
import java.util.List;

public class OnTrackTaskFilter {

    public List<Task> getTasksByTargetGrade(String targetGrade) {
        List<Task> tasks = new ArrayList<>();

        if (targetGrade.equals("Pass")) {
            tasks.add(new Task("1.1P", "Evidence week 1 learning", "Pass"));
            tasks.add(new Task("1.2P", "Browser automation using Selenium", "Pass"));
        }

        if (targetGrade.equals("Credit")) {
            tasks.add(new Task("1.1P", "Evidence week 1 learning", "Pass"));
            tasks.add(new Task("1.2P", "Browser automation using Selenium", "Pass"));
            tasks.add(new Task("3.2C", "Equivalence class test case", "Credit"));
        }

        if (targetGrade.equals("Distinction")) {
            tasks.add(new Task("1.1P", "Evidence week 1 learning", "Pass"));
            tasks.add(new Task("1.2P", "Browser automation using Selenium", "Pass"));
            tasks.add(new Task("3.2C", "Equivalence class test case", "Credit"));
            tasks.add(new Task("6.2D", "Right-BICEP and code coverage", "Distinction"));
        }
        
        if (targetGrade.equals("High Distinction")) {
            tasks.add(new Task("1.1P", "Evidence week 1 learning", "Pass"));
            tasks.add(new Task("1.2P", "Browser automation using Selenium", "Pass"));
            tasks.add(new Task("3.2C", "Equivalence class test case", "Credit"));
            tasks.add(new Task("6.2D", "Right-BICEP and code coverage", "Distinction"));
            tasks.add(new Task("7.2H", "CI/CD with Google Cloud Platform", "High Distinction"));
        }

        return tasks;
    }
}