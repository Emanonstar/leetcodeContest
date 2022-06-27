import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution4 {
    int[] XOR;
    int[] depth;
    boolean[] marked;
    boolean[] inSub;
    Map<Integer, Set<Integer>> neighbors;

    public int minimumScore(int[] nums, int[][] edges) {
        neighbors = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            neighbors.put(i, new HashSet<>());
        }

        clear(nums);

        for (int[] edge: edges) {
            int v = edge[0];
            int w = edge[1];
            neighbors.get(v).add(w);
            neighbors.get(w).add(v);
        }

        int ans = Integer.MAX_VALUE, s1, s2, s3;
        for (int i = 0; i < edges.length; i++) {
            clear(nums);
            int[] edge1 = edges[i];
            DFS(edge1[0], 0, edge1[1], false);
            s2 = XOR[edge1[1]];
            s1 = XOR[edge1[0]] ^ s2;
            for (int j = i + 1; j < edges.length; j++) {
                int[] edge2 = edges[j];
                int l;
                if (depth[edge2[0]] > depth[edge2[1]]) {
                    l = edge2[0];
                } else {
                    l = edge2[1];
                }
                s3 = XOR[l];
                int ss1, ss2;
                if (inSub[l]) {
                    ss2 = s2 ^ s3;
                    ss1 = s1;
                } else {
                    ss1 = s1 ^ s3;
                    ss2 = s2;
                }
                ans = Integer.min(ans, Integer.max(ss1, Integer.max(ss2, s3)) - Integer.min(ss1, Integer.min(ss2, s3)));
            }
        }
        return ans;
    }

    private void DFS(int v, int d, int k, boolean insub) {
        depth[v] = d;
        marked[v] = true;
        inSub[v] = insub;
        Set<Integer> neighborsOf = neighbors.get(v);
        if (neighborsOf.isEmpty()) {
            return;
        }
        int tmp = XOR[v];
        for (int w : neighborsOf) {
            if (!marked[w]) {
                if (w == k) {
                    DFS (w, d + 1, k, true);
                } else {
                    DFS (w, d + 1, k, insub);
                }
                tmp = tmp ^ XOR[w];
            }
        }
        XOR[v] = tmp;
    }

    private void clear(int[] nums) {
        depth = new int[nums.length];
        marked = new boolean[nums.length];
        XOR = new int[nums.length];
        inSub = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            marked[i] = false;
            XOR[i] = nums[i];
            inSub[i] = false;
        }
    }
}
