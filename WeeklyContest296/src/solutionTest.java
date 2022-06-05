import org.junit.Test;
import static org.junit.Assert.*;

public class solutionTest {
    @Test
    public void testSolution1() {
        Solution1 s = new Solution1();
        int[] nums = {1, 3, 5, 2, 4, 8, 2, 2};
        assertEquals(1, s.minMaxGame(nums));
    }

    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        int[] nums = {16,8,17,0,3,17,8,20};
        assertEquals(2, s.partitionArray(nums, 10));
    }

    @Test
    public void testSolution3() {
        Solution3 s = new Solution3();
        int[] nums = {1,2,4,6};
        int[][] operations = {{1, 3}, {4, 7}, {6, 1}};
        int[] exp = {3, 2, 7, 1};
        assertArrayEquals(exp, s.arrayChange(nums, operations));
    }

    @Test
    public void testTextEditor() {
        TextEditor textEditor = new TextEditor();
        assertEquals("|", textEditor.getCurrentText());
        textEditor.addText("leetcode");
        assertEquals("leetcode|", textEditor.getCurrentText());
        assertEquals(4, textEditor.deleteText(4));
        assertEquals("leet|", textEditor.getCurrentText());
        textEditor.addText("practice");
        assertEquals("etpractice", textEditor.cursorRight(3));
        assertEquals("leet", textEditor.cursorLeft(8));
        assertEquals(4, textEditor.deleteText(10));
        assertEquals("", textEditor.cursorLeft(2));
        assertEquals("practi", textEditor.cursorRight(6));

    }
}

