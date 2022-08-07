import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class solutionTest {

    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        int[][] edges = {{8,2},{2,5},{5,0},{2,7},{1,7},{3,8},{0,4},{3,9},{1,6}};
        int[] r = {9,8,4,5,3,1};
        assertEquals(1, s.reachableNodes(10,edges,r));
    }

    @Test
    public void testSolution3() {
        Solution3 s = new Solution3();
        int[] nums1 = {783377,783378,783379,783380,783381,783382,783383,783384,783385,783386,783387,783388,14925,
                14925,14925,190887,190887,190887,444668,444668,444668,444668,444669,444670,444671,444672,444673,
                444674};
        assertEquals(true, s.validPartition(nums1));
        int[] nums2 = {4,4,4, 5,6};
        assertEquals(true, s.validPartition(nums2));
    }

    @Test
    public void testSolution4() {
        Solution4 s = new Solution4();
        String ss = "acfgbd";
        assertEquals(4, s.longestIdealString(ss, 2));
    }

}
