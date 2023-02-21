class Solution3 {
    int mod = 1000000007;
    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    Long[][] mem;
    public int squareFreeSubsets(int[] nums) {
        mem = new Long[1001][1024];
        return (int) ((dfs(0, nums, 0) - 1 + mod) % mod);
    }

    private long dfs(int i, int[] nums, int mask) {
        if (i == nums.length) {
            return 1;
        }
        if (mem[i][mask] != null) {
            return mem[i][mask];
        }
        long rst = dfs(i + 1, nums, mask);
        int maskNext = mask;
        boolean addNum = true;
        for (int j = 0; j < 10; j++) {
            int num = nums[i], cnt = 0;
            while (num % prime[j] == 0) {
                num /= prime[j];
                cnt += 1;
            }
            if (cnt >= 2 || ((cnt == 1) && ((maskNext & (1 << j)) != 0))) {
                addNum = false;
                break;
            }
            if (cnt > 0) {
                maskNext |= (1 << j);
            }
        }
        if (addNum) {
            rst = (rst + dfs(i + 1, nums, maskNext)) % mod;
        }
        return mem[i][mask] = rst;
    }
}
