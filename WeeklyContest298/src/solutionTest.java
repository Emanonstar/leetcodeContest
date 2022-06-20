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
        assertEquals(-1, s.minimumNumbers(4, 8));
        assertEquals(-1, s.minimumNumbers(10, 8));
        assertEquals(10, s.minimumNumbers(10, 1));
        assertEquals(10, s.minimumNumbers(20, 1));
        assertEquals(10, s.minimumNumbers(30, 1));
        assertEquals(1, s.minimumNumbers(1, 1));
        assertEquals(1, s.minimumNumbers(3000, 0));
        assertEquals(1, s.minimumNumbers(119, 9));
        assertEquals(10, s.minimumNumbers(3000, 1));
    }

    @Test
    public void testSolution3() {
        String str1 = "111100010000011101001110001111000000001011101111111110111000011111011000010101110100110110001111001001011001010011010000011111101001101000000101101001110110000111101011000101";
        String str = "00101001";
        Solution3 s = new Solution3();
        assertEquals(96, s.longestSubsequence(str1, 11713332));
        assertEquals(6, s.longestSubsequence(str, 1));
    }

    @Test
    public void testSolution4() {


    }
}
