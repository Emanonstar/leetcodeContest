class Solution3 {
    int n = 32;
    public int longestNiceSubarray(int[] nums) {
        int l = nums.length;
        int[] longestEndAt = new int[l];
        int[] lastIndex = new int[n];
        for (int i = 0; i < n; i++) {
            lastIndex[i] = -1;
        }

        longestEndAt[0] = 1;
        int num = nums[0];
        for (int j = 0; j < n; j++) {
            if ((num & 1) == 1) {
                lastIndex[j] = 0;
            }
            num = num >> 1;
        }
        int ans = 1;
        for (int i = 1; i < l; i++) {
            num = nums[i];
            int mark = -1;
            for (int j = 0; j < n; j++) {
                int pos = -1;
                if ((num & 1) == 1) {
                    pos = lastIndex[j];
                    lastIndex[j] = i;
                }
                num = num >> 1;
                mark = Integer.max(mark, pos);
            }
            if (mark == -1) {
                longestEndAt[i] = longestEndAt[i - 1] + 1;
            } else {
                longestEndAt[i] = i - mark;
                for (int j = 0; j < n; j++) {
                    if (lastIndex[j] <= mark) {
                        lastIndex[j] = -1;
                    }
                }
            }
            ans = Integer.max(ans, longestEndAt[i]);
        }
        return ans;
    }
}
