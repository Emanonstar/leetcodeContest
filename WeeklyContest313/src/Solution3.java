class Solution3 {
    public int minimizeXor(int num1, int num2) {
        int[] bits1 = new int[32];
        int[] bits2 = new int[32];
        int[] bits = new int[32];
        num2bits(num1, bits1);
        num2bits(num2, bits2);
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (bits2[i] != 0) {
                count += 1;
            }
        }
        for (int i = 31; i >= 0; i--) {
            if (bits1[i] != 0 && count > 0) {
                bits[i] = 1;
                count -= 1;
            }
        }
        if (count > 0) {
            for (int i = 0; i < 32; i++) {
                if (bits1[i] == 0 && count > 0) {
                    bits[i] = 1;
                    count -= 1;
                }
            }
        }

        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            ans = ans * 2 + bits[i];
        }
        return ans;
    }

    private void num2bits(int num, int[] bits) {
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                bits[i] = 1;
            }
        }
    }
}
