import java.util.Arrays;

class Solution4 {
    public int minOperations(int[] nums, int[] numsDivide) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxFactor = numsDivide[0];
        for (int num : numsDivide) {
            maxFactor = maxCommonFactor(maxFactor, num);
        }

        for (int i = 0; i < n; i++) {
            if (maxFactor % nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private int maxCommonFactor(int m, int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (m > n) {
            return maxCommonFactor(m % n, n);
        } else {
            return maxCommonFactor(m, n % m);
        }
    }
}
