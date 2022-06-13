class Solution4 {
    long[] sums;
    public long countSubarrays(int[] nums, long k) {
        sums = new long[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = i;
            int r = nums.length - 1;
            int index = i - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (hasScore(i, mid, k)) {
                    index = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (hasScore(i, l, k)) {
                index = l;
            }
            count = count + index - i + 1;
        }
        return count;
    }

    private boolean hasScore(int s, int t, long k) {
        long score = (long)(sums[t + 1] - sums[s]) * (t - s + 1);
        return score < k;
    }
}
