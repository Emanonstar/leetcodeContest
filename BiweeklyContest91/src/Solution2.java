class Solution2 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long mod = 1000000007;
        long[] array = new long[high + 1];
        array[zero] += 1;
        array[one] += 1;
        for (int i = 0; i <= high; i++) {
            if (i - zero > 0) {
                array[i] = (array[i] + array[i - zero]) % mod;
            }

            if (i - one > 0) {
                array[i] = (array[i] + array[i - one]) % mod;
            }
        }

        long ans = 0;
        for (int i = low; i <= high; i++) {
            ans = (ans + array[i]) % mod;
        }
        return (int) ans;
    }
}
