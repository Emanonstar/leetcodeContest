import java.util.Collections;
import java.util.List;

class Solution3 {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (o1, o2) -> o1.get(1) - o2.get(1));
        int[] dp = new int[n + 1];
        int last = 0, ans = -1;
        for (List<Integer> offer: offers) {
            for (int i = last; i < offer.get(1) + 1; i++) dp[i] = dp[last];
            dp[offer.get(1) + 1] = Math.max(dp[offer.get(1) + 1], dp[offer.get(0)] + offer.get(2));
            dp[offer.get(1) + 1] = Math.max(dp[offer.get(1) + 1], dp[offer.get(1)]);
            last = offer.get(1) + 1;
            ans = Math.max(ans, dp[offer.get(1) + 1]);
        }
        return ans;
    }
}
