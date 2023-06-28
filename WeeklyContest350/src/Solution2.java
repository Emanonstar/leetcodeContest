import java.util.Arrays;

class Solution2 {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < l - 1; i++) ans = Integer.min(ans, nums[i + 1] - nums[i]);
        return ans;
    }
}
