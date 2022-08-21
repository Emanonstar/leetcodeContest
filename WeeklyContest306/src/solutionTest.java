import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class solutionTest {

    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        int[] edge = {2, 0, 0, 2};
        assertEquals(0, s.edgeScore(edge));
    }

    @Test
    public void testSolution4() {
        Solution4 s = new Solution4();
        assertEquals(5760090, s.countSpecialNumbers(1474845852));
        assertEquals(1005, s.countSpecialNumbers(1581));
        assertEquals(178, s.countSpecialNumbers(225));
        assertEquals(90, s.countSpecialNumbers(99));
    }
}
