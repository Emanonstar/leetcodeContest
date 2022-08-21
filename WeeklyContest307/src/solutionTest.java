import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class solutionTest {

    @Test
    public void testSolution1() {
        Solution1 s = new Solution1();
        int[] e = {1, 4};
        int[] ee = {2, 5};
        assertEquals(2, s.minNumberOfHours(5, 3, e, ee));
    }

    @Test
    public void testSolution4() {
        Solution4 s = new Solution4();
        int[] nums1 = {2, 4, -2};
        assertEquals(2, s.kSum(nums1, 5));
        int[] nums2 = {-530219056,353285209,493533664};
        assertEquals(-36685392, s.kSum(nums2, 6));
    }

}
