class Solution4 {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = (int) 1e9;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i + 1][j] = Math.min(dp[i][Math.max(j - time[i] - 1, 0)] + cost[i], dp[i][j]);
            }
        }
        return dp[n][n];
    }
}
