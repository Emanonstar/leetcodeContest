class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int l = nums.length;
        int[] maxOr = new int[l];
        maxOr[l - 1] = nums[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            maxOr[i] = nums[i] | maxOr[i + 1];
        }
        int[] ans = new int[l];
        ans[l - 1] = 1;
        int[] lastPosOf = new int[32];
        for (int i = 0; i < 32; i++) {
            lastPosOf[i] = -1;
        }
        for (int i = 0; i < 32; i++) {
            if ((nums[l - 1] & (1 << i)) != 0) {
                lastPosOf[i] = l - 1;
            }
        }
        for (int i = l - 2; i >= 0; i--) {
            int num = nums[i];
            boolean flag = false;
            for (int j = 0; j < 32; j++) {
                if ((maxOr[i] & (1 << j)) != 0 && (num & (1 << j)) == 0) {
                    ans[i] = Integer.max(ans[i], lastPosOf[j] - i + 1);
                    flag = true;
                }
                if ((num & (1 << j)) != 0) {
                    lastPosOf[j] = i;
                }
                if (!flag) {
                    ans[i] = 1;
                }
            }
        }
        return ans;
    }
}
