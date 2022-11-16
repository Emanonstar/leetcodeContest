class Solution2 {
    public int subarrayLCM(int[] nums, int k) {
        int l = nums.length;
        int ans = 0;
        for (int i = 0; i < l; i++) {
            int fact = nums[i];
            if (nums[i] == k) {
                ans += 1;
            }
            for (int j = i + 1; j < l; j++) {
                fact = fact * nums[j] / largestCommonFactor(fact, nums[j]);
                if (fact == k) {
                    ans += 1;
                }
                if (fact > k) {
                    break;
                }
            }
        }
        return ans;
    }

    private int largestCommonFactor(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        if (a < b) {
            return largestCommonFactor(a, b % a);
        } else {
            return largestCommonFactor(a % b, b);
        }
    }
}
