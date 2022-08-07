import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class solutionTest {

    @Test
    public void testSolution3() {
        Solution3 s = new Solution3();
        int[] tasks1 = {1,2,1,2,3,1};
        assertEquals(9, s.taskSchedulerII(tasks1, 3));
    }
}
