import java.util.Arrays;

class Solution1 {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int rst = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                for (int j = i; j < nums.length; j++) {
                    nums[j] -= num;
                }
                rst += 1;
            }
        }
        return rst;
    }
}
