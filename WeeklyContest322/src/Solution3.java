import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution3 {
    public int minScore(int n, int[][] roads) {
        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        Map<Integer, Integer> distances = new HashMap<>();
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            neighbors.put(i, new HashSet<>());
        }
        for (int[] road: roads) {
            int u = road[0];
            int v = road[1];
            neighbors.get(u).add(v);
            neighbors.get(v).add(u);
            distances.put(hash(u, v), road[2]);
            distances.put(hash(v, u), road[2]);
        }
        return DFS(neighbors, distances, 1, visited, Integer.MAX_VALUE);
    }

    private int DFS(Map<Integer, Set<Integer>> neighbors, Map<Integer, Integer> distances, int s, boolean[] visited, int minScore) {
        for (int v: neighbors.get(s)) {
            minScore = Integer.min(minScore, distances.get(hash(s, v)));
            if (!visited[v]) {
                visited[v] = true;
                minScore = Integer.min(minScore, DFS(neighbors, distances, v, visited, minScore));
            }
        }
        return minScore;
    }
    private int hash(int u, int v) {
        return 10 * u + v;
    }

}
