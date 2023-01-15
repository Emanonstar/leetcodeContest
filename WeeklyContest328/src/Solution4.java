import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution4 {
    Map<Integer, List<Integer>> neighbors;
    Map<Long, Long> mem;
    public long maxOutput(int n, int[][] edges, int[] price) {
        neighbors = new HashMap<>();
        mem = new HashMap<>();
        for (int i = 0; i < n; i++) {
            neighbors.put(i, new ArrayList<>());
        }
        for (int[] edge: edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Long.max(ans, DFS(i, -1, price) - price[i]);
        }
        return ans;
    }

    private long DFS(int s, int parent, int[] price) {
        long key = (long) parent * 100000 + s;
        if (mem.containsKey(key)) return mem.get(key);
        long ans = price[s];
        for (int v: neighbors.get(s)) {
            if (v == parent) continue;
            ans = Long.max(ans, price[s] + DFS(v, s, price));
        }
        mem.put(key, ans);
        return ans;
    }
}
