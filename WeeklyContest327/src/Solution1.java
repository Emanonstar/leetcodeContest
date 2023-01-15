class Solution1 {
    public int maximumCount(int[] nums) {
        int l = nums.length;
        int cnt1 = 0, cnt2 = 0;
        for (int num: nums) {
            if (num < 0) {
                cnt1 += 1;
            }
            if (num > 0) {
                cnt2 += 1;
            }
        }
        return Integer.max(cnt1, cnt2);
    }
}
