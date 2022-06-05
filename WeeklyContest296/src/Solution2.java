import java.util.Arrays;

class Solution2 {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ceiling = nums[0] + k;
        int count = 1;
        for (int n : nums) {
            if (n > ceiling) {
                ceiling = n + k;
                count++;
            }
        }
        return count;
    }
}
