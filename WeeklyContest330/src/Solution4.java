class Solution4 {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n];
        long ans = 0;
        for (int l = 0; l < n; l++) {
            int preSmall = 0;
            for (int j = 0; j < l; j++) {
                if (nums[j] < nums[l]) {
                    preSmall += 1;
                    ans += dp[j];
                } else {
                    dp[j] += preSmall;
                }
            }
        }
        return ans;
    }
}
