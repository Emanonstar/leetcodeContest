class Solution1 {
    public int[] applyOperations(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < l - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int[] ans = new int[l];
        for (int i = 0, j = 0; i < l; i++) {
            if (nums[i] != 0) {
                ans[j] = nums[i];
                j += 1;
            }
        }
        return ans;
    }
}
