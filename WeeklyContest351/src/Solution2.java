class Solution2 {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int i = 1; i < 61; i++) {
            long target = num1 - i * (long)num2;
            if (Long.bitCount(target) <= i && i <= target) return i;
        }
        return -1;
    }
}
