import java.util.Arrays;

class Solution2 {
    public int minimizeSum(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        return Integer.min(Integer.min(nums[l - 1] - nums[2], nums[l - 3] - nums[0]),
                nums[l - 2] - nums[1]);
    }
}
