import java.util.Arrays;

class Solution2 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans + rightMost(nums, i, upper - nums[i]) - leftMost(nums, i, lower - nums[i]);
        }
        return ans;
    }

    private int leftMost(int[] nums, int index, int lower) {
        int start = index + 1;
        int end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < lower) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private int rightMost(int[] nums, int index, int upper) {
        int start = index + 1;
        int end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= upper) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
