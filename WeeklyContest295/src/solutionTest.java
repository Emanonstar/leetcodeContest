import org.junit.Test;
import static org.junit.Assert.*;

public class solutionTest {
    @Test
    public void testSolution1() {
        Solution1 s = new Solution1();
        assertEquals(s.rearrangeCharacters("a", "a"), 1);
        assertEquals(s.rearrangeCharacters("rav", "vr"), 1);
        assertEquals(s.rearrangeCharacters("ilovecodingonleetcode", "code"), 2);
        assertEquals(1, s.rearrangeCharacters("abbaccaddaeea", "aaaaa"));
        assertEquals(2, s.rearrangeCharacters("lrnvlcqukanpdnluowenfxquitzryponxsikhciohyostvmkapkfpglzikitwiraqgchxnpryhwpuwpozacjhmwhjvslprqlnxrk", "woijih"));


    }


    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        assertEquals("there are $0.50 $1.00 and 5$ candies in the shop", s.discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
        assertEquals("1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$", s.discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
        assertEquals("ka3caz4837h6ada4 r1 $547.82", s.discountPrices("ka3caz4837h6ada4 r1 $602", 9));
        assertEquals("1$0", s.discountPrices("1$0", 9));

    }

    @Test
    public void testSolution3() {
        Solution3 s = new Solution3();
        int[] nums1 = {5,3,4,4,7,3,6,11,8,5,11};
        int[] nums2 = {10,1,2,3,4,5,6,1,2,3};
        int[] nums3 = {3, 3, 3};
        assertEquals(3, s.totalSteps(nums1));
        assertEquals(6, s.totalSteps(nums2));
        assertEquals(0, s.totalSteps(nums3));

    }

    @Test
    public void testSolution4() {
        Solution4 s = new Solution4();
        int[][] grid1 = {{0,1,1},{1,1,0},{1,1,0}};
        assertEquals(2, s.minimumObstacles(grid1));

        int[][] grid2 = {{0,1,0,0,0},{0,1,0,1,0},{0,0,0,1,0}};
        assertEquals(0, s.minimumObstacles(grid2));
    }

}
