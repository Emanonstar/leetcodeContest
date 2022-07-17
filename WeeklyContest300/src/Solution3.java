class Solution3 {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000007;
        int[] delays = new int[delay + 1];
        int[] forgets = new int[forget + 1];
        int[] rst = new int[n];

        rst[0] = 1;
        delays[delay] = 1;
        forgets[forget] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < forget; j++) {
                forgets[j] = forgets[j + 1];
            }

            delays[0] = (int) (((long) delays[0] + delays[1] - forgets[0]) % mod);
            for (int j = 1; j < delay; j++) {
                delays[j] = delays[j + 1];
            }

            delays[delay] = delays[0];
            forgets[forget] = delays[0];
            rst[i] = (int) (((long) rst[i - 1] + delays[0] - forgets[0]) % mod);
        }
        return (rst[n - 1] + mod) % mod;
    }
}
