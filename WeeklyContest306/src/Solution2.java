class Solution2 {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] score = new long[n];
        boolean[] hasSocre = new boolean[n];

        for (int i = 0; i < n; i++) {
            score[i] = 0;
            hasSocre[i] = false;
        }

        for (int i = 0; i < n; i++) {
            score[edges[i]] += i;
            hasSocre[edges[i]] = true;
        }

        int rst = -1;
        long max_score = -1;
        for (int i = 0; i < n; i++) {
            if (hasSocre[i] && (score[i] > max_score)) {
                rst = i;
                max_score = score[i];
            }
        }
        return rst;
    }
}
