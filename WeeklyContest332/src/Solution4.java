import java.util.Arrays;

class Solution4 {
    public int minimumScore(String s, String t) {
        int l = t.length();
        int[] dp = new int[l];
        Arrays.fill(dp, -1);
        int p = l - 1;

        for (int i = s.length() - 1; i >= 0 && p >= 0; i--) {
            if (s.charAt(i) == t.charAt(p)) {
                dp[p] = i;
                p -= 1;
            }
        }
        int ans = p + 1;
        for (int i = 0, j = 0; i < s.length() && j < l && p >= 0; i++) {
            if (s.charAt(i) == t.charAt(j)) {
                while (p < l && dp[p] <= i) {
                    p += 1;
                }
                ans = Integer.min(ans, p - j - 1);
                j += 1;
            }
        }
        return ans;
    }
}
