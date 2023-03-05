class Solution4 {
    public int waysToReachTarget(int target, int[][] types) {
        int mod = 1000000007;
        int l = types.length;
        long[][] dp = new long[l][target + 1];
        for (int j = 0; j <= types[0][0]; j++) {
            int points = j * types[0][1];
            if (points <= target) dp[0][points] = 1;
        }

        for (int i = 1; i < l; i++) {
            for (int j = 0; j <= target; j++) {
                for (int k = 0; k <= types[i][0]; k++) {
                    int points = j + k * types[i][1];
                    if (points <= target) dp[i][points] = (dp[i][points] + dp[i - 1][j]) % mod;
                }
            }
        }
        return (int) dp[l - 1][target];
    }
}
