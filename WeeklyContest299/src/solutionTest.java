import org.junit.Test;
import static org.junit.Assert.*;

public class solutionTest {
    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        assertEquals(169, s.countHousePlacements(5));
        assertEquals(500478595, s.countHousePlacements(1000));
        assertEquals(452249287, s.countHousePlacements(9468));

    }

    @Test
    public void testSolution3() {
        Solution3 s = new Solution3();
        int[] a = {3140};
        assertEquals(3140, s.maximumsSplicedArray(a,a));
    }

    @Test
    public void testSolution4() {
        Solution4 s = new Solution4();
//        int[] nums1 = {1, 5, 5, 4, 11};
//        int[][] edges1 = {{0,1},{1,2},{1,3},{3,4}};
//        assertEquals(9, s.minimumScore(nums1, edges1));

        int[] nums2 = {5,5,2,4,4,2};
        int[][] edges2 = {{0,1},{1,2},{5,2},{4,3},{1,3}};
        assertEquals(0, s.minimumScore(nums2, edges2));
    }

}
