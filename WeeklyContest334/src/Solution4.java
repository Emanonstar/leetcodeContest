import java.util.PriorityQueue;

class Solution4 {
    int m;
    int n;
    int[][] dist;
    int[][] grid;
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        return BFS(0, 0);
    }

    private int BFS(int i, int j) {
        dist[i][j] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[0] - p2[0]);
        pq.add(new int[] {0, 0, 0});
        while (!pq.isEmpty()) {
            int[] u = pq.poll();
            int t = u[0], x = u[1], y = u[2];
            add(pq, x - 1, y, t + 1);
            add(pq, x + 1, y, t + 1);
            add(pq, x, y - 1, t + 1);
            add(pq, x, y + 1, t + 1);
        }
        return dist[m - 1][n - 1];
    }

    private void add(PriorityQueue<int[]> pq, int i, int j, int t) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        int nt = t;
        if (grid[i][j] > nt) {
            nt = (grid[i][j] - nt) % 2 == 0 ? grid[i][j] : grid[i][j] + 1;
        }
        if (dist[i][j] > nt) {
            dist[i][j] = nt;
            pq.add(new int[]{nt, i, j});
        }
    }
}
