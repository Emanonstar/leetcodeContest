class Solution3 {
    public long minCost(int[] nums, int x) {
        int l = nums.length;
        int[] min = new int[l];
        for (int i = 0; i < l; i++) min[i] = nums[i];
        long ans = 0;
        for (int n: min) ans += n;
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < l; j++) {
                min[j] = Math.min(min[j], nums[(j + i) % l]);
            }
            long tmp = (long) i * x;
            for (int n: min) tmp += n;
            ans = Math.min(ans, tmp);
        }
        return ans;
    }
}
