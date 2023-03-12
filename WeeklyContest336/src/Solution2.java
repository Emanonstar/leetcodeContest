import java.util.Arrays;

class Solution2 {
    public int maxScore(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        long[] preSum= new long[l];
        preSum[0] = nums[l - 1];
        for (int i = 1; i < l; i++) {
            preSum[i] = preSum[i - 1] + nums[l - 1 - i];
        }
        int ans = 0;
        for (long p: preSum) {
            if (p > 0) ans += 1;
        }
        return ans;
    }
}
