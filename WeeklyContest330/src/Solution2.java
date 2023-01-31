class Solution2 {
    int mol = 1000000007;

    public int monkeyMove(int n) {
        int ans = (int) (twoTo(n) - 2);
        if (ans <= 0) {
            ans += mol;
        }
        return ans;
    }

    private long twoTo(int n) {
        if (n == 0) {
            return 1;
        }
        long tmp = twoTo(n / 2);
        long ans = (tmp * tmp) % mol;
        if (n % 2 == 0) {
            return ans;
        } else {
            return (2 * ans) % mol;
        }
    }
}
