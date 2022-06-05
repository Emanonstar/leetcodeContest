class Solution1 {
    public int minMaxGame(int[] nums) {
        while (nums.length > 1) {
            int[] newNums = new int[nums.length / 2];
            for (int i = 0; i < nums.length / 2; i++) {
                if (i % 2 == 0) {
                    newNums[i] = Integer.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    newNums[i] = Integer.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = newNums;
        }
        return nums[0];
    }
}
