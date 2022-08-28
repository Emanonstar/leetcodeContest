import java.util.Arrays;

class Solution1 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int l = nums.length;
        int ll = queries.length;
        Arrays.sort(nums);
        int[] sums = new int[l];
        sums[0] = nums[0];
        for (int i = 1; i < l; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        int[] rst = new int[ll];
        for (int i = 0; i < ll; i++) {
            int quer = queries[i];
            int j;
            for (j = l - 1; j >= 0; j--) {
                if (sums[j] <= quer) {
                    break;
                }
            }
            rst[i] = j + 1;
        }
        return rst;
    }
}
