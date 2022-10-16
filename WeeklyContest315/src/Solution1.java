class Solution1 {
    public int findMaxK(int[] nums) {
        int l = nums.length;
        int ans = -1;
        for (int num1: nums) {
            for (int num2: nums) {
                if (num2 == -num1) {
                    ans = Integer.max(ans, num1);
                }
            }
        }
        return ans;
    }
}
