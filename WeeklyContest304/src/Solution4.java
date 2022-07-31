class Solution4 {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] marked = new int[n];
        for (int i = 0; i < n; i++) {
            marked[i] = -1;
        }
        int rst = -1;
        for (int i = 0; i < n; i++) {
            int p = i;
            if (marked[p] == -1) {
                marked[p] = i;
                while (edges[p] != -1) {
                    if (marked[edges[p]] == i) {
                        int c = edges[p];
                        int l = 1;
                        int pp = c;
                        while (edges[pp] != c) {
                            pp = edges[pp];
                            l += 1;
                        }

                        if (l > rst) {
                            rst = l;
                        }
                        break;
                    } else {
                        if (marked[edges[p]] == -1) {
                            p = edges[p];
                            marked[p] = i;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return rst;
    }
}
