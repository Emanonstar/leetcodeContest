import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class solutionTest {
    @Test
    public void testSolution1() {
        Solution1 s = new Solution1();
        assertEquals("this is a secret", s.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }

    @Test
    public void testSolution3() {
        Solution3 s = new Solution3();
        assertEquals(5, s.peopleAwareOfSecret(6, 2, 4));
        assertEquals(6, s.peopleAwareOfSecret(4, 1, 3));
    }

    @Test
    public void testSolution4() {
        Solution4 s = new Solution4();
        int[][] grid1 = {{1,1},{3,4}};
        assertEquals(8, s.countPaths(grid1));
    }

}
