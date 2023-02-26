class Solution1 {
    public int[] leftRigthDifference(int[] nums) {
        int l = nums.length;
        int[] prefix = new int[l + 2];
        for (int i = 0; i < l; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int[] ans = new int[l];
        for (int i = 0; i < l; i++) {
            ans[i] = Math.abs(prefix[i] - (prefix[l] - prefix[i + 1]));
        }
        return ans;
    }
}
