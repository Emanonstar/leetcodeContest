import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution4 {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        Map<Integer, Set<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(vals[i])) {
                map.get(vals[i]).add(i);
            } else {
                Set<Integer> set = new TreeSet<>();
                set.add(i);
                map.put(vals[i], set);
            }
        }

        Map<Integer, Set<Integer>> neighbors = new TreeMap<>();
        for (int[] edge: edges) {
            int max, min;
            if (vals[edge[0]] > vals[edge[1]]) {
                max = edge[0];
                min = edge[1];
            } else {
                max = edge[1];
                min = edge[0];
            }
            if (neighbors.containsKey(max)) {
                neighbors.get(max).add(min);
            } else {
                Set<Integer> set = new TreeSet<>();
                set.add(min);
                neighbors.put(max, set);
            }
        }

        int ans = n;
        DSU dsu = new DSU(n);
        for (int val: map.keySet()) {
            for (int s: map.get(val)) {
                if (neighbors.containsKey(s)) {
                    for (int v: neighbors.get(s)) {
                        dsu.join(s, v);
                    }
                }
            }

            Map<Integer, Integer> vmap = new TreeMap<>();
            for (int s: map.get(val)) {
                int root = dsu.find(s);
                if (vmap.containsKey(root)) {
                    vmap.put(root, vmap.get(root) + 1);
                } else {
                    vmap.put(root, 1);
                }
            }

            for (int s: vmap.keySet()) {
                int size = vmap.get(s);
                ans += (size * (size - 1) / 2);
            }
        }
        return ans;
    }

    static class DSU {
        int[] array;
        int[] size;

        DSU(int n) {
            array = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = i;
                size[i] = 1;
            }
        }

        int find(int s) {
            if (array[s] == s) {
                return s;
            }
            return array[s] = find(array[s]);
        }

        void join(int s, int v) {
            int r1 = find(s);
            int r2 = find(v);
            if (r1 == r2) {
                return;
            }
            if (size[r1] > size[r2]) {
                array[r2] = r1;
                size[r1] += size[r2];
            } else {
                array[r1] = r2;
                size[r2] += size[r1];
            }
        }

        int getSize(int s) {
            return size[s];
        }
    }
}
