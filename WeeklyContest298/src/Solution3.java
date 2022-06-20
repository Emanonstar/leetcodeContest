class Solution3 {

    /* greedy */
    public int longestSubsequence(String s, int k) {
        int n = 0;
        int cnt = 0;
        int pow = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '1') {
                n += pow;
                if (n > k) {
                    break;
                }
                cnt += 1;
            }
            pow *= 2;
            if (pow > k) {
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                cnt += 1;
            }
        }
        return cnt;
    }

    /** DP
     * public int longestSubsequence(String s, int k) {
     *         int[] rst = new int[1001];
     *         for (int i = 0; i < s.length(); i++) {
     *             char c = s.charAt(i);
     *             int[] tmp = new int[1001];
     *             for (int j = 1; j < i + 1; j++) {
     *                 if (rst[j - 1] > k) {
     *                     tmp[j] = rst[j];
     *                 } else {
     *                     tmp[j] = Integer.min(rst[j], 2 * rst[j - 1] + (c - '0'));
     *                 }
     *             }
     *             if (rst[i] > k) {
     *                 tmp[i + 1] = rst[i];
     *             } else {
     *                 tmp[i + 1] = 2 * rst[i] + (c - '0');
     *             }
     *             rst = tmp;
     *         }
     *         for (int i = s.length(); i > 0; i--) {
     *             if (rst[i] <= k) {
     *                 return i;
     *             }
     *         }
     *         return 0;
     *     }
    */
}
