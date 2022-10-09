class Solution1 {
    public int commonFactors(int a, int b) {
        int min = Integer.min(a, b);
        int ans = 0;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                ans += 1;
            }
        }
        return ans;
    }
}
