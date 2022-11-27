class Solution4 {
    public int countPalindromes(String s) {
        int mol = 1000000007;
        int l = s.length();
        if (l < 5) {
            return 0;
        }
        int[][] dp1 = new int[l][10];
        int[][] dp2 = new int[l][100];
        dp1[0][s.charAt(0) - '0'] = 1;
        for (int i = 1; i < l; i++) {
            int c = s.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {
                dp1[i][j] = dp1[i - 1][j];
            }
            dp1[i][c] += 1;
        }

        for (int i = 1; i < l; i++) {
            int c = s.charAt(i) - '0';
            for (int j = 0; j < 100; j++) {
                dp2[i][j] = dp2[i - 1][j];
            }
            for (int j = 0; j < 10; j++) {
                dp2[i][j * 10 + c] += dp1[i - 1][j];
            }
        }
        int[][] dp3 = new int[l][10];
        int[][] dp4 = new int[l][100];
        dp3[l - 1][s.charAt(l - 1) - '0'] = 1;
        for (int i = l - 2; i > 0; i--) {
            int c = s.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {
                dp3[i][j] = dp3[i + 1][j];
            }
            dp3[i][c] += 1;
        }

        for (int i = l - 2; i > 0; i--) {
            int c = s.charAt(i) - '0';
            for (int j = 0; j < 100; j++) {
                dp4[i][j] = dp4[i + 1][j];
            }
            for (int j = 0; j < 10; j++) {
                dp4[i][j * 10 + c] += dp3[i + 1][j];
            }
        }
        long[] ans = new long[l];
        for (int i = 2; i < l - 2; i++) {
            ans[i] = ans[i - 1];
            for (int j = 0; j < 100; j++) {
                ans[i] = (ans[i] + (long) dp2[i - 1][j] * dp4[i + 1][j]) % mol;
            }
            //System.out.println(ans[i]);
        }
        return (int) ans[l - 3];
    }
}
