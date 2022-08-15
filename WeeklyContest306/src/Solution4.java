class Solution4 {
    String num;
    int l;
    int ans;

    public int countSpecialNumbers(int n) {
        num = Integer.toString(n);
        l = num.length();
        int[] prev = new int[10];
        ans = 0;

        for (int i = 0; i < l; i++) {
            ans += count(i);
            prev[num.charAt(i) - '0'] += 1;
        }

        for (int i = 0; i < 10; i++) {
            if (prev[i] > 1) {
                return ans;
            }
        }
        return (ans + 1);
    }

    private int count(int pos) {
        char bit = num.charAt(pos);
        int p = bit - '1';
        int[] prev = new int[10];
        for (int i = 0; i < pos; i++) {
            prev[num.charAt(i) - '0'] += 1;
        }

        for (int i = 0; i < 10; i++) {
            if (prev[i] > 1) {
                return 0;
            }
        }

        for (int i = 0; i < bit - '0'; i++) {
            if (prev[i] == 1) {
                p -= 1;
            }
        }

        if (p < 0) {
            return 0;
        }

        int rst;
        if (pos == 0) {
            rst = p * A(9 - pos, l - 1 - pos);
            for (int i = 0; i < l - 1 - pos; i++) {
                rst += (9 - pos) * A(9 - pos, i);
            }
        } else {
            p += 1;
            rst = p * A(9 - pos, l - 1 - pos);
        }

        return rst;
    }

    private int A(int m, int n) {
        if (n == 0) {
            return 1;
        }

        if (m == 0) {
            return 0;
        }

        return m * A(m - 1, n - 1);
    }
}
