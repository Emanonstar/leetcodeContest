class Solution1 {
    public boolean findSubarrays(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < l - 1; i++) {
            long s = (long) nums[i] + nums[i + 1];
            for (int j = i + 1; j < l - 1; j++) {
                long ss = (long) nums[j] + nums[j + 1];
                if (ss == s) {
                    return true;
                }
            }
        }
        return false;
    }
}
