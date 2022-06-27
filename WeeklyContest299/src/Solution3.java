class Solution3 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int l = nums1.length;
        int sums1 = 0;
        int sums2 = 0;
        for (int i = 0; i < l; i++) {
            sums1 += nums1[i];
            sums2 += nums2[i];
        }

        int[] diff = new int[l];
        for (int i = 0; i < l; i++) {
            diff[i] = nums1[i] - nums2[i];
        }
        int s1 = diff[0];
        int s2 = -diff[0];
        int ans = Integer.max(s1 + sums2, s2 + sums1);
        for (int j = 1; j < l; j++) {
            s1 = Math.max(s1 + diff[j], diff[j]);
            ans = Math.max(ans, s1 + sums2);
            s2 = Math.max(s2 - diff[j], -diff[j]);
            ans = Math.max(ans, s2 + sums1);
        }
        return ans;
    }

    /** Prefix sum method.
     * public int maximumsSplicedArray(int[] nums1, int[] nums2) {
     *         int l = nums1.length;
     *         int[] sums1 = new int[l];
     *         int[] sums2 = new int[l];
     *         sums1[0] = nums1[0];
     *         sums2[0] = nums2[0];
     *         for (int i = 1; i < l; i++) {
     *             sums1[i] = sums1[i - 1] + nums1[i];
     *             sums2[i] = sums2[i - 1] + nums2[i];
     *         }
     *
     *         int[] diff = new int[l];
     *         for (int i = 0; i < l; i++) {
     *             diff[i] = sums1[i] - sums2[i];
     *         }
     *         int s1 = diff[0];
     *         int s2 = -diff[0];
     *         int ans = Integer.MIN_VALUE;
     *         for (int j = 0; j < l; j++) {
     *             ans = Math.max(ans, -diff[j] + sums1[l - 1]);
     *             ans = Math.max(ans, diff[j] + sums2[l - 1]);
     *         }
     *         for (int j = 1; j < l; j++) {
     *             s1 = Math.max(s1, diff[j - 1]);
     *             ans = Math.max(ans, s1 - diff[j] + sums1[l - 1]);
     *             s2 = Math.max(s2, -diff[j - 1]);
     *             ans = Math.max(ans, s2 + diff[j] + sums2[l - 1]);
     *         }
     *         return ans;
     *     }
     */
}
