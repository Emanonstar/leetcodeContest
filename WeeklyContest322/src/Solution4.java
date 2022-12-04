import java.util.*;

class Solution4 {
    public int magnificentSets(int n, int[][] edges) {
        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            neighbors.put(i, new TreeSet<>());
        }

        for (int[] e: edges) {
            int u = e[0];
            int v = e[1];
            neighbors.get(u).add(v);
            neighbors.get(v).add(u);
        }

        List<Set<Integer>> CCs = new ArrayList<>();
        for (int s = 1; s <= n; s++) {
            if (!visited[s]) {
                Set<Integer> cc = new HashSet<>();
                cc.add(s);
                visited[s] = true;
                DFS(neighbors, cc, s, visited);
                CCs.add(cc);
            }
        }

        int ans = 0;
        for (Set<Integer> cc: CCs) {
            int max = 0;
            for (int s: cc) {
                visited = new boolean[n + 1];
                int[] depth = new int[n + 1];
                Queue<Integer> queue = new ArrayDeque<>();
                visited[s] = true;
                queue.add(s);
                int h = 1;
                depth[s] = h;
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    h = depth[u];
                    for (int v: neighbors.get(u)) {
                        if (visited[v]) {
                            if (Math.abs(depth[u] - depth[v]) != 1) {
                                return -1;
                            }
                        } else {
                            visited[v] = true;
                            depth[v] = h + 1;
                            queue.add(v);
                        }
                    }
                }
                max = Integer.max(max, h);
            }
            ans += max;
        }
        return ans;
    }

    private void DFS(Map<Integer, Set<Integer>> neighbors, Set<Integer> cc, int s, boolean[] visited) {
        for (int v: neighbors.get(s)) {
            if (!visited[v]) {
                cc.add(v);
                visited[v] = true;
                DFS(neighbors, cc, v, visited);
            }
        }
    }
}
