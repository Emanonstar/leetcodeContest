class Solution3 {
    public int maximumXorProduct(long a, long b, int n) {
        long mod = 1000000007;
        long x = 0;
        int max = -1;
        for (int i = 0; i < 64; i++) {
            if ((a & (1L << i)) != (b & (1L << i))) max = i;
        }
        //System.out.println(max);
        if (n <= max) {
            if (a > b) {
                long tmp = b;
                b = a;
                a = tmp;
            }
            for (int i = n - 1; i >= 0; i--) {
                if ((a & (1L << i)) == 0) x = x | (1L << i);
            }
            //System.out.println("1");
        } else {
            boolean next = true;
            for (int i = n - 1; i >= 0; i--) {
                if ((a & (1L << i)) != (b & (1L << i))) {
                    if (next) {
                        if ((a & (1L << i)) == 0) x = x | (1L << i);
                        next = false;
                    } else {
                        if ((b & (1L << i)) == 0) x = x | (1L << i);
                    }
                } else {
                    if ((a & (1L << i)) == 0) x = x | (1L << i);
                }
            }
        }
        //System.out.println(x);
        return (int)((((a ^ x) % mod) * ((b ^ x) % mod)) % mod);
    }
}
