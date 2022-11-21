import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution4 {
    public int beautifulPartitions(String s, int k, int minLength) {
        int mol = 1000000007;
        Set<Character> prime = new HashSet<>(Arrays.asList('2', '3', '5', '7'));
        int l = s.length();
        if (k == 1) {
            if (prime.contains(s.charAt(0)) && !prime.contains(s.charAt(l - 1))) {
                return 1;
            }
            return 0;
        }
        long[][] dp = new long[l][k];
        for (int i = minLength - 1; i < l - 1; i++) {
            long last = 0;
            if (i - 1 >= 0) {
                last = dp[i - 1][1];
            }
            if (prime.contains(s.charAt(0)) && !prime.contains(s.charAt(i)) && prime.contains(s.charAt(i + 1))) {
                dp[i][1] = 1 + last;
            } else {
                dp[i][1] = last;
            }
        }
        for (int i = 1; i < l - 1; i++) {
            int pre = -1;
            for (int j = i - minLength; j > 0; j--) {
                if (prime.contains(s.charAt(j + 1)) && !prime.contains(s.charAt(j))) {
                    pre = j;
                    break;
                }
            }

            for (int m = 2; m < k; m++) {
                dp[i][m] = dp[i - 1][m];
                if (pre != -1 && !prime.contains(s.charAt(i)) && prime.contains(s.charAt(i + 1))) {
                    dp[i][m] = (dp[i][m] + dp[pre][m - 1]) % mol;
                }
            }
        }

        int ans = 0;
        int pre = -1;
        for (int j = l - 1 - minLength; j > 0; j--) {
            if (prime.contains(s.charAt(j + 1)) && !prime.contains(s.charAt(j))) {
                pre = j;
                break;
            }
        }
        if (pre != -1 && !prime.contains(s.charAt(l - 1))) {
            ans = (int) dp[pre][k - 1];
        }
        return ans;
    }

//    public int beautifulPartitions(String s, int k, int minLength) {
//        int mol = 1000000007;
//        Set<Character> prime = new HashSet<>(Arrays.asList('2', '3', '5', '7'));
//        int l = s.length();
//        long[][] dp = new long[l][k + 1];
//        for (int i = minLength - 1; i < l; i++) {
//            if (prime.contains(s.charAt(0)) && !prime.contains(s.charAt(i))) {
//                dp[i][1] = 1;
//            }
//        }
//        for (int i = 0; i < l; i++) {
//            for (int j = 0; j <= i - minLength; j++) {
//                for (int m = 2; m <= k; m++) {
//                    if (prime.contains(s.charAt(j + 1)) && !prime.contains(s.charAt(i))) {
//                        dp[i][m] = (dp[i][m] + dp[j][m - 1]) % mol;
//                    }
//                }
//            }
//        }
//        return (int) dp[l - 1][k];
//    }
}
