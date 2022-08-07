import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution2 {
    Map<Integer, Set<Integer>> map;
    Set<Integer> reachable;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> restric  = new HashSet<>();
        for (int r : restricted) {
            restric.add(r);
        }

        map = new HashMap<>();
        for (int[] edge: edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            if (!restric.contains(n1) && !restric.contains(n2)) {
                if (map.containsKey(n1)) {
                    map.get(n1).add(n2);
                } else {
                    Set<Integer> s = new HashSet<>();
                    s.add(n2);
                    map.put(n1, s);
                }

                if (map.containsKey(n2)) {
                    map.get(n2).add(n1);
                } else {
                    Set<Integer> s = new HashSet<>();
                    s.add(n1);
                    map.put(n2, s);
                }
            }
        }
        reachable = new HashSet<>();
        reachable.add(0);
        traverse(0);
        return reachable.size();
    }

    private void traverse(int s) {
        if (!map.containsKey(s)) {
            return;
        }

        for (int node: map.get(s)) {
            if (!reachable.contains(node)) {
                reachable.add(node);
                traverse(node);
            }
        }
    }
}
