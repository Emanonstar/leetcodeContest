class Solution2 {
    public int longestSubarray(int[] nums) {
        int l = nums.length;
        int max = -1;
        for (int n : nums) {
            max = Integer.max(max, n);
        }
        int ans = 0;
        int n = 0;
        for (int i = 0; i < l; i++) {
            if (nums[i] == max) {
                if (i > 0 && nums[i - 1] == max) {
                    n += 1;
                } else {
                    n = 1;
                }
            }
            ans = Integer.max(ans, n);
        }
        return ans;
    }
}
