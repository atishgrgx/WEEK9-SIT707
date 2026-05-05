package sit707_week9;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Unit tests for OnTrack task filtering.
 * 
 * These tests are written before the full implementation
 * to follow the TDD approach.
 */
public class OnTrackTaskFilterTest {

    private OnTrackTaskFilter filter;

    @Before
    public void setUp() {
        filter = new OnTrackTaskFilter();
    }

    @Test
    public void testPassGradeShowsOnlyPassTasks() {
        // Act
        List<Task> tasks = filter.getTasksForTargetGrade("Pass");

        // Assert
        Assert.assertEquals(99, tasks.size());

        for (Task task : tasks) {
            Assert.assertEquals("Pass", task.getGradeLevel());
        }
    }

    @Test
    public void testCreditGradeShowsPassAndCreditTasks() {
        // Act
        List<Task> tasks = filter.getTasksForTargetGrade("Credit");

        // Assert
        Assert.assertEquals(5, tasks.size());

        for (Task task : tasks) {
            Assert.assertTrue(
                    task.getGradeLevel().equals("Pass")
                            || task.getGradeLevel().equals("Credit")
            );
        }
    }

    @Test
    public void testDistinctionGradeShowsPassCreditAndDistinctionTasks() {
        // Act
        List<Task> tasks = filter.getTasksForTargetGrade("Distinction");

        // Assert
        Assert.assertEquals(7, tasks.size());

        for (Task task : tasks) {
            Assert.assertTrue(
                    task.getGradeLevel().equals("Pass")
                            || task.getGradeLevel().equals("Credit")
                            || task.getGradeLevel().equals("Distinction")
            );
        }
    }

    @Test
    public void testHighDistinctionGradeShowsAllTasks() {
        // Act
        List<Task> tasks = filter.getTasksForTargetGrade("High Distinction");

        // Assert
        Assert.assertEquals(8, tasks.size());
    }

    @Test
    public void testInvalidTargetGradeThrowsException() {
        // Act + Assert
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            filter.getTasksForTargetGrade("Invalid Grade");
        });
    }

    @Test
    public void testEmptyTargetGradeThrowsException() {
        // Act + Assert
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            filter.getTasksForTargetGrade("");
        });
    }

    @Test
    public void testNullTargetGradeThrowsException() {
        // Act + Assert
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            filter.getTasksForTargetGrade(null);
        });
    }
}