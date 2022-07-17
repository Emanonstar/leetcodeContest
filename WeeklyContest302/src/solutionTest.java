import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class solutionTest {

    @Test
    public void testSolution1() {
        Solution1 s = new Solution1();
        int[] n1 = {1,3,2,1,3,2,2};
        int[] s1 = {3, 1};
        assertArrayEquals(s1, s.numberOfPairs(n1));

    }



    @Test
    public void testSolution4() {
        Solution4 s = new Solution4();
        int[] n1 = {2,3,2,4,3};
        int[] s1 = {9,6,9,3,15};
        assertEquals(2, s.minOperations(n1, s1));
    }



}
