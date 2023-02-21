class Solution1 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] vals = new int[1001];
        for (int[] n1: nums1) {
            vals[n1[0]] += n1[1];
        }
        for (int[] n2: nums2) {
            vals[n2[0]] += n2[1];
        }
        int l = 0;
        for (int v: vals) {
            if (v != 0) {
                l += 1;
            }
        }
        int[][] ans = new int[l][2];
        int index = 0;
        for (int i = 0; i < 1001; i++) {
            if (vals[i] != 0) {
                ans[index][0] = i;
                ans[index][1] = vals[i];
                index += 1;
            }
        }
        return ans;
    }
}
