class Solution4 {
    int[][] pathsEndAt;
    int[][] grid;
    int height;
    int width;
    int mod = 1000000007;
    public int countPaths(int[][] grid) {
        height = grid.length;
        width = grid[0].length;
        pathsEndAt = new int[height][width];
        this.grid = grid;

        long rst = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rst = (rst + dfs(i, j)) % mod;
            }
        }
        return (int) rst;
    }

    private int dfs(int r, int c) {
        if (pathsEndAt[r][c] != 0) {
            return pathsEndAt[r][c];
        }

        long ans = 1;
        int val = grid[r][c];
        int[][] drts = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int nr, nc;
        for (int[] drt: drts) {
            nr = r + drt[0];
            nc = c + drt[1];
            if (nr >= 0 && nc >= 0 && nr < height && nc < width) {
                int nextVal = grid[nr][nc];
                if(val > nextVal) {
                    ans = (ans + dfs(nr, nc)) % mod;
                }
            }
        }
        return pathsEndAt[r][c] = (int) ans;
    }
}
