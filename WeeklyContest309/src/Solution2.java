class Solution2 {
    int mod = 1000000007;
    public int numberOfWays(int startPos, int endPos, int k) {

        int d = endPos - startPos;
        d = (d > 0) ? d : -d;
        if ((k + d) % 2 != 0 || d > k) {
            return 0;
        }
        int x = (k + d) / 2;
        long ans = 1;
        for (int i = 0; i < x; i++) {
            ans = (((ans * (k - i)) % mod) * power(x - i, mod - 2)) % mod;
        }
        return (int) ans;
    }

    private long power(int a, int x) {
        if (x == 1) {
            return a;
        }
        if (x == 0) {
            return 1;
        }

        long tmp = power(a, x / 2) % mod;
        if (x % 2 == 0) {
            return (tmp * tmp) % mod;
        } else {
            return (a * ((tmp * tmp) % mod)) % mod;
        }
    }
}
