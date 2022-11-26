class Solution2 {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] diffRow = new int[m];
        int[] diffCol = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    diffRow[i] += 1;
                    diffCol[j] += 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            diffRow[i] = 2 * diffRow[i] - n;
        }

        for (int i = 0; i < n; i++) {
            diffCol[i] = 2 * diffCol[i] - m;
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = diffRow[i] + diffCol[j];
            }
        }
        return ans;
    }
}
