import org.junit.Test;
import static org.junit.Assert.*;

public class solutionTest {
    @Test
    public void testSolution4() {
        Solution4 s = new Solution4();
        assertEquals(22,s.distinctSequences(2));
        assertEquals(446979947,s.distinctSequences(23));
    }
}
