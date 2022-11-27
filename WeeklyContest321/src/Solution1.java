class Solution1 {
    public int pivotInteger(int n) {
        for (int i = 1; i <= n; i++) {
            if ((i + 1) * i == (n + i) * (n - i + 1)) {
                return i;
            }
        }
        return -1;
    }
}
