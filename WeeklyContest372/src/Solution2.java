class Solution2 {
    public long minimumSteps(String s) {
        long ans = 0;
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                ans += ones;
            } else {
                ones += 1;
            }
        }
        return ans;
    }
}
