import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class solutionTest {

    @Test
    public void testSolution1() {
        Solution1 s = new Solution1();
        String blocks = "BWWWBB";
        assertEquals(3, s.minimumRecolors(blocks, 6));
    }

    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        assertEquals(4, s.secondsToRemoveOccurrences("0110101"));
        assertEquals(5, s.secondsToRemoveOccurrences("000111"));
        assertEquals(0, s.secondsToRemoveOccurrences("0"));
        assertEquals(0, s.secondsToRemoveOccurrences("1"));
        assertEquals(20,s.secondsToRemoveOccurrences("1001111111110001011001110000000110101"));
    }

    @Test
    public void testSolution3() {
        Solution3 s = new Solution3();
        int[][] shifts = {{0,1,0},{1,2,1},{0,2,1}};
        assertEquals("ace", s.shiftingLetters("abc", shifts));
    }

    @Test
    public void testSolution4() {
        Solution4 s = new Solution4();
        int[] n = {1,2,5,6,1};
        int[] r = {0,3,2,4,1};
        long[] a = {14,7,2,2,0};
        assertArrayEquals(a, s.maximumSegmentSum(n, r));
    }

}
