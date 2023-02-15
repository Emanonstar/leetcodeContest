class Solution1 {
    public long findTheArrayConcVal(int[] nums) {
        int l = nums.length;
        long ans = 0;
        if (l % 2 != 0) {
            ans += nums[l / 2];
        }
        for (int i = 0; i < l / 2; i++) {
            int ll = String.valueOf(nums[l - 1 - i] ).length();
            long add = nums[i];
            for (int j = 0; j < ll; j++) {
                add *= 10;
            }
            add += nums[l - 1 - i];
            ans += add;
        }
        return ans;
    }
}