class Solution3 {
    public long makeIntegerBeautiful(long n, int target) {
        String s = String.valueOf(n);
        int l = s.length();
        int[] sums = new int[l];
        sums[0] = s.charAt(0) - '0';
        for (int i = 1; i < l; i++) {
            sums[i] = sums[i - 1] + (s.charAt(i) - '0');
        }

        if (sums[l - 1] <= target) {
            return 0;
        }

        for (int i = 1; i < l; i++) {
            if (sums[l - 1 - i] + 1 <= target) {
                long mol = 1;
                for (int j = 0; j < i; j++) {
                    mol *= 10;
                }
                return mol - n % mol;
            }
        }
        long mol = 1;
        for (int j = 0; j < l; j++) {
            mol *= 10;
        }
        return mol - n % mol;
    }
}
