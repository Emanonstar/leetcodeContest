import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class solutionTest {

    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        int[] b1 = {20,30,10};
        int[] p1 = {19,13,26,4,25,11,21};
        assertEquals(20, s.latestTimeCatchTheBus(b1, p1, 2));
        int[] b2 = {3};
        int[] p2 = {2, 4};
        assertEquals(3, s.latestTimeCatchTheBus(b2, p2, 2));
    }

    @Test
    public void testSolution3() {
        Solution3 s = new Solution3();
        int[] n1 = {1,2,3,4};
        int[] n2 = {2,10,20,19};
        assertEquals(579, s.minSumSquareDiff(n1, n2, 0, 0));
    }
}