class Solution2 {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = -1;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int tmp = grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] + grid[i][j]
                        + grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1];
                ans = Integer.max(tmp, ans);
            }
        }
        return ans;
    }
}
