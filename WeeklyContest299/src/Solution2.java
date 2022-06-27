class Solution2 {
    public int countHousePlacements(int n) {
        long l0 = 0;
        long l1 = 1;
        int i = 0;
        long result = 1;
        while (i < n) {
            long tmp = result;
            result = (result % 1000000007 + (3 * l1) % 1000000007 + (result - l1 - l0) % 1000000007) % 1000000007;
            l0 = l1;
            l1 = tmp;
            i += 1;
        }
        result = result % 1000000007;
        while (result < 0) {
            result += 1000000007;
        }
        return (int) (result);
    }
}
