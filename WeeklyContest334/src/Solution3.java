import java.util.Arrays;

class Solution3 {
    public int maxNumOfMarkedIndices(int[] nums) {
        int l = nums.length;
        boolean[] marked = new boolean[l];
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0, j = l / 2; i < l && j < l; i++) {
            if (marked[i]) {
                break;
            }
            while (j < l && 2 * nums[i] > nums[j]) {
                j += 1;
            }
            if (j < l && 2 * nums[i] <= nums[j]) {
                marked[i] = true;
                marked[j] = true;
                j += 1;
                ans += 2;
            }
        }
        return ans;
    }
}
