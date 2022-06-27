class Solution4 {
    int mod = 1000000007;
    public int distinctSequences(int n) {
        if (n == 1) {
            return 6;
        }
        int[][][] cache = new int[n][6][6];
        for (int j = 0; j < 6; j++) {
            for (int k = 0; k < 6; k++) {
                if (j != k && greatestCommonDivosorIs1(j + 1, k + 1)) {
                    cache[1][j][k] = 1;
                } else {
                    cache[1][j][k] = 0;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (j == k || !greatestCommonDivosorIs1(j + 1, k + 1)) {
                        cache[i][j][k] = 0;
                    } else {
                        long tmp = 0;
                        for (int l = 0; l < 6; l++) {
                            if (l != k) {
                                tmp += cache[i - 1][l][j];
                            }
                        }
                        cache[i][j][k] = (int) (tmp % mod);
                    }
                }
            }
        }
        long rst = 0;
        for (int j = 0; j < 6; j++) {
            for (int k = 0; k < 6; k++) {
                rst =  (rst + cache[n - 1][j][k]) % mod;
            }
        }
        return (int) rst;
    }

    private boolean greatestCommonDivosorIs1(int a, int b) {
        int l = Integer.min(a, b);
        for (int i = 2; i <= l; i++) {
            if (a % i == 0 && b % i == 0) {
                return false;
            }
        }
        return true;
    }
}
