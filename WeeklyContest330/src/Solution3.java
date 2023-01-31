import java.util.Arrays;

class Solution3 {
    public long putMarbles(int[] weights, int k) {
        int l = weights.length - 1;
        long[] cut = new long[l];
        for (int i = 0; i < l; i++) {
            cut[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(cut);
        long ans = 0;
        for (int i = 0; i < k - 1; i++) {
            ans += (cut[l - 1 - i] - cut[i]);
        }
        return ans;
    }
}
