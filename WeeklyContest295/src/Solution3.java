import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution3 {
    
    public int totalSteps(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] stepsToDelete = new int[nums.length];
        stack.push(0);
        stepsToDelete[0] = 0;
        int ts = 0;

        for (int i = 1; i < nums.length; i++) {
            int tt = 0;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                tt = Integer.max(tt, stepsToDelete[stack.pop()]);
            }

            if (stack.isEmpty()) {
                stepsToDelete[i] = 0;
            } else {
                stepsToDelete[i] = tt + 1;
            }
            stack.push(i);
            ts = Integer.max(ts, stepsToDelete[i]);
        }
        return ts;
    }

    /* Naive method. */
    public int totalSteps1(int[] nums) {
        List<Integer> numsL = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            numsL.add(nums[i]);
        }
        int count = 0;
        while (true) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(numsL.get(0));
            for (int i = 1; i < numsL.size(); i++) {
                if (numsL.get(i) >= numsL.get(i - 1)) {
                    tmp.add(numsL.get(i));
                }
            }
            if (tmp.size() == numsL.size()) {
                break;
            } else {
                numsL = tmp;
                count += 1;
            }
        }
        return count;
    }
}
