import org.junit.Test;
import static org.junit.Assert.*;

public class solutionTest {
    @Test
    public void testSolution1() {

    }

    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        int[] a = {1, 2, 3};
        s.successfulPairs(a, a, 5);
    }

    @Test
    public void testSolution3() {

    }

    @Test
    public void testSolution4() {
        Solution4 s = new Solution4();
        int[] a = {1, 1, 1};
        assertEquals(5, s.countSubarrays(a, 5));
    }
}
