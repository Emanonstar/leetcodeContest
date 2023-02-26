class Solution2 {
    public int[] divisibilityArray(String word, int m) {
        int l = word.length();
        long num = 0;
        int[] ans = new int[l];
        for (int i = 0; i < l; i++) {
            num = (num * 10 + word.charAt(i) - '0') % m;
            if (num == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }
}
