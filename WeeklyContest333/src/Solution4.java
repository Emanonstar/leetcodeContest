class Solution4 {
    public String findTheString(int[][] lcp) {
        int l = lcp.length, c = 0;
        int[] A = new int[l];
        for (int i = 0; i < l; i++) {
            if (A[i] > 0) continue;
            c += 1;
            if (c > 26) return "";
            for (int j = i; j < l; j++) {
                if (lcp[i][j] > 0) {
                    A[j] = c;
                }
            }
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                int v = i + 1 < l && j + 1 < l ? lcp[i + 1][j + 1] : 0;
                v = A[i] == A[j] ? v + 1 : 0;
                if (lcp[i][j] != v) return "";
            }
        }
        StringBuilder stringBuilder= new StringBuilder();
        for (int a: A) {
            stringBuilder.append((char)('a' + a - 1));
        }
        return stringBuilder.toString();
    }
}
