class Solution2 {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        char last = s.charAt(0);
        int l = 1;
        int ans = 1;

        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c - last == 1) {
                l += 1;
            } else {
                ans = Integer.max(ans, l);
                l = 1;
            }
            last = c;
        }
        return Integer.max(ans, l);
    }
}
