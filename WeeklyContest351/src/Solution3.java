class Solution3 {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int l = nums.length;
        int mod = 1000000007;
        boolean isFirst = true;
        long ans = 1;
        int cnt = 0;
        for (int i: nums) {
            cnt += 1;
            if (i == 1) {
                if (!isFirst) {
                    ans = ans * cnt % mod;
                    cnt = 0;
                } else {
                    isFirst = false;
                    cnt = 0;
                }
            }
        }
        if (isFirst) return 0;
        return (int) ans;
    }
}
