class Solution2 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];
        for (int[] q: queries) {
            for (int i = q[0]; i <= q[2]; i++) {
                for (int j = q[1]; j <= q[3]; j++) {
                    ans[i][j] += 1;
                }
            }
        }
        return ans;
    }
}
