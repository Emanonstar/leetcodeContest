import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class solutionTest {
    @Test
    public void testSolution3() {
        Solution3 s = new Solution3();
        int[][] mat = {{1,0,1,0,0,0,0,0},{0,0,0,1,1,0,0,1},{0,0,1,1,1,1,1,1},{0,1,0,0,1,1,0,1},{0,1,0,0,1,0,0,0}};
        assertEquals(3, s.maximumRows(mat, 5));
    }
}
