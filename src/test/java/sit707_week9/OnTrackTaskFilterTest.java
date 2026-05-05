package sit707_week9;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Test cases for the OnTrack task filtering function.
 */
public class OnTrackTaskFilterTest {

    private OnTrackTaskFilter filter;

    @Before
    public void setUp() {
        // Create a new filter object before each test.
        filter = new OnTrackTaskFilter();
    }

    @Test
    public void testPassGradeShowsOnlyPassTasks() {
        // Get tasks for Pass target grade.
        List<Task> tasks = filter.getTasksForTargetGrade("Pass");

        // There should be 3 Pass tasks.
        Assert.assertEquals(3, tasks.size());

        // Check that every returned task is a Pass task.
        for (Task task : tasks) {
            Assert.assertEquals("Pass", task.getGradeLevel());
        }
    }

    @Test
    public void testCreditGradeShowsPassAndCreditTasks() {
        // Get tasks for Credit target grade.
        List<Task> tasks = filter.getTasksForTargetGrade("Credit");

        // There should be 3 Pass tasks and 2 Credit tasks.
        Assert.assertEquals(5, tasks.size());

        // Check that every returned task is either Pass or Credit.
        for (Task task : tasks) {
            Assert.assertTrue(task.getGradeLevel().equals("Pass") || task.getGradeLevel().equals("Credit")
            );
        }
    }

    @Test
    public void testDistinctionGradeShowsPassCreditAndDistinctionTasks() {
        // Get tasks for Distinction target grade.
        List<Task> tasks = filter.getTasksForTargetGrade("Distinction");

        // There should be Pass, Credit, and Distinction tasks.
        Assert.assertEquals(7, tasks.size());

        // Check that every returned task belongs to the allowed grade levels.
        for (Task task : tasks) {
            Assert.assertTrue(task.getGradeLevel().equals("Pass") || task.getGradeLevel().equals("Credit") || task.getGradeLevel().equals("Distinction")
            );
        }
    }

    @Test
    public void testHighDistinctionGradeShowsAllTasks() {
        // Get tasks for High Distinction target grade.
        List<Task> tasks = filter.getTasksForTargetGrade("High Distinction");

        // High Distinction target grade should show all tasks.
        Assert.assertEquals(8, tasks.size());
    }
}