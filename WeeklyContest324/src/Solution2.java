class Solution2 {
    public int smallestValue(int n) {
        int last = n;
        while (true) {
            int k = 2;
            int value = 0;
            while (k <= n) {
                if (n % k == 0) {
                    value += k;
                    n = n / k;

                } else {
                    k += 1;
                }
            }
            if (last == value) {
                return value;
            } else {
                n = value;
                last = value;
            }
        }
    }
}
