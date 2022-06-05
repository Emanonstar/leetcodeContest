import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public int[] arrayChange(int[] nums, int[][] operations) {

        Map<Integer, Integer> op = new HashMap<>();
        for (int i = operations.length - 1; i >= 0; i--) {
            int[] operation = operations[i];
            if (op.containsKey(operation[1])) {
                op.put(operation[0], op.get(operation[1]));
            } else {
                op.put(operation[0], operation[1]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (op.containsKey(nums[i])) {
                nums[i] = op.get(nums[i]);
            }
        }
        return nums;
    }
}
