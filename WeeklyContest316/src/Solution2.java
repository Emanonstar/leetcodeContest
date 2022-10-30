class Solution2 {
    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            if (nums[i] == k) {
                ans += 1;
            }
            int gcd = nums[i];
            for (int j = i + 1; j < l; j++) {
                gcd = GCD(gcd, nums[j]);
                if (gcd == k) {
                    ans += 1;
                }
            }
        }
        return ans;
    }

    private int GCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        if (a < b) {
            return GCD(a, b % a);
        } else {
            return GCD(a % b, b);
        }
    }
}
