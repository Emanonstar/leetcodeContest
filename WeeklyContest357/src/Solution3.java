import java.util.*;

class Solution3 {
    int[][] drts = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        Queue<Tuple> thieves = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) thieves.add(new Tuple(i, j));
            }
        }
        int[][] dist = new int[n][n];
        BFS(thieves, dist, n);
        int l = 0, r = 400;
        while (l < r) {
            int mid = (l + r) / 2;
            if (isConnect(dist, mid, n)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (isConnect(dist, l, n)) return l;
        return l - 1;
    }

    private void BFS(Queue<Tuple> thieves, int[][] dist, int n) {
        boolean[][] visited = new boolean[n][n];
        for (Tuple thief: thieves) visited[thief.row][thief.col] = true;
        while (!thieves.isEmpty()) {
            Tuple t = thieves.poll();
            int r = t.row, c = t.col;
            for (int[] drt: drts) {
                int newR = r + drt[0], newC = c + drt[1];
                if (newR >= 0 && newR < n && newC >= 0 && newC < n) {
                    if (!visited[newR][newC]) {
                        dist[newR][newC] = dist[r][c] + 1;
                        thieves.add(new Tuple(newR, newC));
                        visited[newR][newC] = true;
                    }
                }
            }
        }
    }
    private boolean isConnect(int[][] dist, int limit, int n) {
        boolean[][] valid = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] >= limit) valid[i][j] = true;
            }
        }
        if (!valid[0][0] || !valid[n - 1][n - 1]) return false;
        boolean[][] visited = new boolean[n][n];
        DFS(0, 0, n, valid, visited);
        return visited[n - 1][n - 1];
    }

    private void DFS(int r, int c, int n, boolean[][] valid, boolean[][] visited) {
        visited[r][c] = true;
        for (int[] drt: drts) {
            int newR = r + drt[0], newC = c + drt[1];
            if (newR >= 0 && newR < n && newC >= 0 && newC < n) {
                if (valid[newR][newC] && !visited[newR][newC]) {
                    DFS(newR, newC, n, valid, visited);
                }
            }
        }
    }

    private class Tuple{
        int row;
        int col;
        Tuple(int r, int c) {
            row = r;
            col = c;
        }
    }
}
