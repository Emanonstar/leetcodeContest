import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class solutionTest {

    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        assertEquals(3, s.numberOfWays(1,2, 3));
    }

    @Test
    public void testSolution3() {
        Solution3 s = new Solution3();
        int[] nums1 = {1,3,8,48,10};
        assertEquals(3, s.longestNiceSubarray(nums1));
    }

    @Test
    public void testSolution4() {
        Solution4 s = new Solution4();
        int[][] meetings = {{1,20}, {2,10}, {3,5}, {4,9}, {6,8}};
        assertEquals(1, s.mostBooked(3, meetings));
    }
}

