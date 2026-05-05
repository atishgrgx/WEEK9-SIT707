package sit707_week9;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class OnTrackTaskFilterTest {

    @Test
    public void testPassTasks() {
        OnTrackTaskFilter filter = new OnTrackTaskFilter();

        List<Task> tasks = filter.getTasksByTargetGrade("Pass");

        Assert.assertEquals(2, tasks.size());
    }

    @Test
    public void testCreditTasks() {
        OnTrackTaskFilter filter = new OnTrackTaskFilter();

        List<Task> tasks = filter.getTasksByTargetGrade("Credit");

        Assert.assertEquals(3, tasks.size());
    }

    @Test
    public void testDistinctionTasks() {
        OnTrackTaskFilter filter = new OnTrackTaskFilter();

        List<Task> tasks = filter.getTasksByTargetGrade("Distinction");

        Assert.assertEquals(4, tasks.size());
    }
}