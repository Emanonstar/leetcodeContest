import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class solutionTest {

    @Test
    public void testSolution3() {
        Solution3 s = new Solution3();
        int[] edges1 = {1,2,-1};
        assertEquals(2, s.closestMeetingNode(edges1, 0, 2));
        int[] edges2 = {4,4,4,5,1,2,2};
        assertEquals(1, s.closestMeetingNode(edges2, 1, 1));
    }
}
