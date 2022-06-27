import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public long countPairs(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] edge: edges) {
            dsu.connect(edge[0], edge[1]);
        }
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dsu.a[i] == i) {
                l.add(dsu.size[i]);
            }
        }
        long result = (long) n * (long) (n - 1) / 2;
        for (int len : l) {
            result = result - (long) len * (long) (len - 1) / 2;
        }
        return result;
    }

    class DSU {
        int[] a;
        int[] size;

        DSU(int n) {
            a = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = i;
                size[i] = 1;
            }
        }

        boolean isconnected(int m, int n) {
            return find(m) == find(n);
        }

        void connect(int m, int n) {
            int i = find(m);
            int j = find(n);
            if (i == j) {
                return;
            }
            if (size[i] < size[j]) { a[i] = j; size[j] += size[i]; }
            else { a[j] = i; size[i] += size[j]; }

        }

        private int find(int n) {
            while (n != a[n])
                n = a[n];
            return n;
        }
    }
}
