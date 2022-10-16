class Solution3 {
    public int minimizeArrayValue(int[] nums) {
        int l = nums.length;
        long[] preSum = new long[l];
        preSum[0] = nums[0];
        for (int i = 1; i < l; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            if (preSum[i] % (i + 1) == 0) {
                ans = Integer.max(ans, (int)(preSum[i] / (i + 1)));
            } else {
                ans = Integer.max(ans, (int)(preSum[i] / (i + 1)) + 1);
            }
        }
        return ans;
    }
}
