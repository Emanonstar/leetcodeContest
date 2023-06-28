class Solution3 {
    Long[][] mem;
    int l;
    int mod = 1000000007;
    public int specialPerm(int[] nums) {
        l = nums.length;
        int mask = 0;
        mem = new Long[(int)(Math.pow(2, l))][l];
        return dp(nums, 0, mask, -1).intValue();
    }

    private Long dp(int[] nums, int pos, int mask, int last) {
        if (last > 0 && mem[mask][last] != null) return mem[mask][last];
        if (pos >= l) return 1L;
        Long rst = 0L;
        for (int i = 0; i < l; i++) {
            if ((mask & (1 << i)) == 0) {
                int lastNum = (last >= 0) ? nums[last] : 1;
                if (nums[i] % lastNum == 0 || lastNum % nums[i] == 0) {
                    rst = (rst + dp(nums, pos + 1, mask | (1 << i), i)) % mod;
                }
            }
        }
        if (last > 0) mem[mask][last] = rst;
        return rst;
    }
}
