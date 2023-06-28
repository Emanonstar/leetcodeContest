import java.util.Arrays;

class Solution1 {
    public int findNonMinOrMax(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[l - 1];
        for (int n : nums) {
            if (n != min && n != max) return n;
        }
        return -1;
    }
}
