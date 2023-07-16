import java.util.Arrays;

class Solution2 {
    public int maximumBeauty(int[] nums, int k) {
        int l = nums.length;
        Arrays.sort(nums);
        int ans = 1;
        for (int i = 0; i < l; i++) {
            int pos = Arrays.binarySearch(nums,nums[i] + 2 * k);
            if (pos < 0) {
                pos = -pos - i - 1;
            } else {
                int j;
                for (j = pos; j < l; j++) {
                    if (nums[j] != nums[pos]) {
                        break;
                    }
                }
                pos = j - i;
            }
            ans = Math.max(pos, ans);
        }
        return ans;
    }
}
