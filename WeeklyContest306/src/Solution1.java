class Solution1 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] rst = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int max = -1;
                for (int r = i - 1; r < i + 2; r++) {
                    for (int c = j - 1; c < j + 2; c++) {
                        max = Integer.max(grid[r][c], max);
                    }
                }
                rst[i - 1][j - 1] = max;
            }
        }
        return rst;
    }
}
