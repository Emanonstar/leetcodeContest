class Solution4 {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] p = new long[m + 1][n + 1];
        for (int[] price : prices) {
            p[price[0]][price[1]] = price[2];
        }

        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                long max = p[r][c];
                for (int i = 1; i < r; i++) {
                    long tmp = p[i][c] + p[r - i][c];
                    max = Long.max(max, tmp);
                }
                for (int j = 1; j < c; j++) {
                    long tmp = p[r][j] + p[r][c - j];
                    max = Long.max(max, tmp);
                }
                p[r][c] = max;
            }
        }
        return p[m][n];
    }
}
