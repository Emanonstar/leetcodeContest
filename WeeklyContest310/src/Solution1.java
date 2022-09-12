import java.util.Arrays;

class Solution1 {
    public int mostFrequentEven(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        int ans = -1;
        int ansCnt = 0;
        int cnt = 0;
        int last = -1;
        for (int i = 0; i < l; i++) {
            if (nums[i] == last) {
                cnt += 1;
            } else {
                if (last % 2 == 0 && cnt > ansCnt) {
                    ansCnt = cnt;
                    ans = last;
                }
                cnt = 1;
                last = nums[i];
            }
        }
        if (nums[l - 1] % 2 == 0 && cnt > ansCnt) {
            ans = nums[l - 1];
        }
        return ans;
    }
}
