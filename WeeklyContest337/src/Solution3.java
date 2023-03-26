class Solution3 {
    Integer[][] mem;
    public int beautifulSubsets(int[] nums, int k) {
        int l = nums.length;
        mem = new Integer[l][(int)Math.pow(2, l)];
        int mask = 0;
        int ans = DFS(0, l, k, nums, mask) - 1;
        return ans;
    }

    private int DFS(int i, int l, int k, int[] nums, int mask) {
        if (i >= l) return 1;
        if (mem[i][mask] != null) return mem[i][mask];
        int l1 = DFS(i + 1, l, k, nums, mask);
        int l2 = 0;
        boolean f = true;
        for (int n = 0; n < i; n++) {
            if (((1 << n) & mask) != 0 && (Math.abs(nums[i] - nums[n]) == k)) {
                f = false;
                break;
            }
        }
        if (f) {
            l2 = DFS(i + 1, l, k, nums, mask | (1 << i));
        }
        return mem[i][mask] = l1 + l2;
    }
}
