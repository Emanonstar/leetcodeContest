import java.util.Arrays;
import java.util.Stack;

class Solution4 {
    public int[] secondGreaterElement(int[] nums) {
        int l = nums.length;
        int[] ans = new int[l];
        Arrays.fill(ans, -1);
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> tmp = new Stack<>();

        for (int i = 0; i < l; i++) {
            while (!s2.empty() && nums[s2.peek()] < nums[i]) {
                ans[s2.pop()] = nums[i];
            }

            while (!s1.empty() && nums[s1.peek()] < nums[i]) {
                tmp.push(s1.pop());
            }
            s1.push(i);

            while (!tmp.empty()) {
                s2.push(tmp.pop());
            }
        }
        return ans;
    }
}
