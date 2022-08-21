class Solution1 {
    public int minimumRecolors(String blocks, int k) {
        int ans = Integer.MAX_VALUE;
        int l = blocks.length();

        for (int i = 0; i <= l - k; i++) {
            int count = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') {
                    count += 1;
                }
            }
            ans = Integer.min(ans, count);
        }
        return ans;
    }
}
