class Solution1 {
    public int[] evenOddBit(int n) {
        int odd = 0, even = 0;
        int i = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                if (i % 2 == 0) {
                    even += 1;
                } else {
                    odd += 1;
                }
            }
            i += 1;
            n /= 2;
        }
        return new int[]{even, odd};
    }
}
