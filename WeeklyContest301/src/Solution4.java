import java.util.HashSet;
import java.util.Set;
import java.math.BigInteger;

class Solution4 {
    int mod = 1000000007;
    public int idealArrays(int n, int maxValue) {

        long[][] dp = new long[15][maxValue + 1];
        Set<Integer>[] factors = new Set[maxValue + 1];
        for (int i = 1; i < maxValue + 1; i++) {
            dp[1][i] = 1;
            Set<Integer> s = new HashSet<>();
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    s.add(j);
                }
            }
            factors[i] = s;
        }

        for (int i = 2; i <= 14 && i <= n; i++) {
            for (int j = 1; j <= maxValue; j++) {
                long tmp = 0;
                for (int k : factors[j]) {
                    tmp = (tmp +  dp[i - 1][k]) % mod;
                }
                dp[i][j] = tmp;
            }
        }

        for (int i = 1; i <= 14 && i <= n; i++) {
            for (int j = 1; j <= maxValue; j++) {
                dp[i][0] += dp[i][j];
            }
        }

        long rst = 0;
        for (int i = 1; i <= 14 && i <= n; i++) {
            rst = (rst + cNk(n - 1, i - 1).multiply(BigInteger.valueOf(dp[i][0])).mod(BigInteger.valueOf(mod)).longValue()) % mod;
        }
        return (int) rst;
    }

    private BigInteger cNk(int n, int k) {
        BigInteger rst = BigInteger.ONE;
        for (int i = 1; i <= k; i++) {
            rst = rst.multiply(BigInteger.valueOf(n + 1 - i)).divide(BigInteger.valueOf(i));
        }
        return rst;
    }

//    public int idealArrays(int n, int maxValue) {
//        int mod = 1000000007;
//        long[][] dp = new long[n + 1][maxValue + 1];
//        Set<Integer>[] factors = new Set[maxValue + 1];
//        for (int i = 1; i < maxValue + 1; i++) {
//            dp[1][i] = 1;
//            Set<Integer> s = new HashSet<>();
//            for (int j = 1; j <= i; j++) {
//                if (i % j == 0) {
//                    s.add(j);
//                }
//            }
//            factors[i] = s;
//        }
//
//        for (int i = 2; i <= n; i++) {
//            for (int j = 1; j <= maxValue; j++) {
//                long tmp = 0;
//                for (int k : factors[j]) {
//                    tmp = (tmp +  dp[i - 1][k]) % mod;
//                }
//                dp[i][j] = tmp;
//            }
//        }
//
//        long ans = 0;
//        for (int i = 1; i <= maxValue; i++) {
//            ans = (ans + dp[n][i]) % mod;
//        }
//        return (int) ans;
//    }
}