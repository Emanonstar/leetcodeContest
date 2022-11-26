class Solution1 {
    public int numberOfCuts(int n) {
        if (n % 2 == 0 || n == 1) {
            return n / 2;
        } else {
            return n;
        }
    }
}
