class Solution4 {
    public int numberOfPaths(int[][] grid, int k) {
        int mol = 1000000007;
        int m = grid.length;
        int n = grid[0].length;
        long[][][] a = new long[m][n][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    a[i][j][grid[i][j] % k] = 1;
                }
                if (i > 0) {
                    for (int p = 0; p < k; p++) {
                        a[i][j][(grid[i][j] + p) % k] = (a[i][j][(grid[i][j] + p) % k] + a[i - 1][j][p]) % mol;
                    }
                }
                if (j > 0) {
                    for (int p = 0; p < k; p++) {
                        a[i][j][(grid[i][j] + p) % k] = (a[i][j][(grid[i][j] + p) % k] + a[i][j - 1][p]) % mol;
                    }
                }
            }
        }
        return (int)a[m - 1][n - 1][0];
    }
}
