import org.junit.Test;
import static org.junit.Assert.*;

public class solutionTest {
    @Test
    public void testSolution1() {
        Solution1 s = new Solution1();
    }

    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        int[][] grid = {{5,3},{4,0},{2,1}};
        int[][] cost = {{9,8}, {1,5},{10,12},{18,6},{2,4},{14,3}};
        assertEquals(17, s.minPathCost(grid, cost));

    }

    @Test
    public void testSolution3() {

    }

    @Test
    public void testSolution4() {


    }
}
