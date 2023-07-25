class Solution2 {
    public long maxArrayValue(int[] nums) {
        int l = nums.length;
        long ans = 0;
        long tmp = nums[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            if (nums[i] <= tmp) {
                tmp += nums[i];
            } else {

                tmp = nums[i];
            }
        }
        ans = Math.max(ans, tmp);
        return ans;
    }
}
