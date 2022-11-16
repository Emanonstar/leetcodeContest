import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public long maximumSubarraySum(int[] nums, int k) {
        int l = nums.length;
        long[] preSum = new long[l + 1];
        for (int i = 0; i < l; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        Map<Integer, Integer> lastPosition = new HashMap<>();
        long ans = 0;
        int begin = 0;
        for (int i = 0; i < l; i++) {
            if (lastPosition.containsKey(nums[i])) {
                begin = Integer.max(lastPosition.get(nums[i]) + 1, begin);
            }
            if (i - begin + 1 == k) {
                ans = Long.max(ans, preSum[i + 1] - preSum[begin]);
                begin += 1;
            }
            lastPosition.put(nums[i], i);
        }
        return ans;
    }
}
