import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class solutionTest {

    @Test
    public void testSolution3() {
        Solution3 s = new Solution3();
        String s1 = "R_L__R__R_";
        String t1 = "_L______RR";
        assertEquals(false, s.canChange(s1, t1));
        String s2 = "R_L_", t2 = "__LR";
        assertEquals(false, s.canChange(s2, t2));
        String s3 = "_L__R__R_L", t3 = "L______RR_";
        assertEquals(false, s.canChange(s3, t3));
    }

    @Test
    public void testSolution4() {
        Solution4 s = new Solution4();
        assertEquals(10, s.idealArrays(2, 5));
    }

}
