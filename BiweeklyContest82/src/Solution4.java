import java.util.Arrays;

public class Solution4 {
    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        Tuple[] tuples = new Tuple[n];
        boolean[] isFit = new boolean[n];
        for (int i = 0; i < n; i++) {
            tuples[i] = new Tuple(i, nums[i]);
        }
        Arrays.sort(tuples);
        int index = n - 1;
        if (tuples[index].v > threshold) {
            return 1;
        }

        DSU dsu = new DSU(n);
        for (int k = 2; k <= n; k++) {
            int t = threshold / k;
            while (index >= 0 && tuples[index].v > t) {
                int p = tuples[index].p;
                isFit[p] = true;
                if (p - 1 >= 0 && isFit[p - 1]) {
                    dsu.connect(p - 1, p);
                }
                if (p + 1 < n && isFit[p + 1]) {
                    dsu.connect(p + 1, p);
                }
                if (dsu.sizeOf(p) >= k) {
                    return k;
                }
                index -= 1;
            }
        }
        return -1;
    }

    private static class Tuple implements Comparable<Tuple>{
        int p;
        int v;
        Tuple (int p, int v) {
            this.p = p;
            this.v = v;
        }

        @Override
        public int compareTo(Tuple t) {
            return this.v - t.v;
        }
    }
    private static class DSU {
        int[] union;
        int[] size;

        DSU (int n) {
            union = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                union[i] = i;
                size[i] = 1;
            }
        }

        private int find(int s) {
            if (s == union[s]) {
                return s;
            }
            return union[s] = find(union[s]);
        }

        public boolean isConnect(int s, int t) {
            return find(s) == find(t);
        }

        public void connect(int s, int t) {
            int rs = find(s);
            int rt = find(t);
            if (size[rs] > size[rt]) {
                union[rt] = rs;
                size[rs] += size[rt];
            } else {
                union[rs] = rt;
                size[rt] += size[rs];
            }
        }

        public int sizeOf(int s) {
            return size[find(s)];
        }
    }
}
