class Solution2 {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] row = grid[i];
            for (int j = 0; j < n; j++) {
                boolean equal = true;
                for (int k = 0; k < n; k++) {
                    if (row[k] != grid[k][j]) {
                        equal = false;
                        break;
                    }
                }
                if (equal) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
