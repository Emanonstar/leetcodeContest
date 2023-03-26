class Solution4 {
    public int findSmallestInteger(int[] nums, int value) {
        int l = nums.length;
        int[] cnt = new int[value];
        for (int i: nums) {
            if (i < 0) {
                i += ((-i) / value + 1) * value;
            }
            int mod = i % value;
            cnt[mod] += 1;
        }
        for (int i = 0; ; i++) {
            int mod = i % value;
            if (cnt[mod] == 0) return i;
            cnt[mod] -= 1;
        }
    }
}
