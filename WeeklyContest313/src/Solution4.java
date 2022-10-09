class Solution {
    public int deleteString(String s) {
        StringBuffer sb = new StringBuffer(s);
        int l = sb.length();
        int[][] a = new int[l][l + 1];
        for (int i = 0; i < l; i++) {
            a[i][0] = s.charAt(i) - 'a';
            for (int j = 1 ; j < l - i; j++) {
                a[i][j] = (int) (((long) a[i][j - 1] * 26 + s.charAt(i + j) - 'a') % 1000000003);;
            }
        }

        int[] ans = new int[l];
        for (int i = 0; i < l; i++) {
            ans[i] = 1;
        }

        for (int i = l - 2; i >= 0; i--) {
            for (int j = 0; j <= (l - i) / 2; j++) {
                if (i + j + 1 < l && a[i][j] == a[i + j + 1][j]) {
                    ans[i] = Integer.max(ans[i], ans[i + j + 1] + 1);
                }
            }
        }
        return ans[0];
    }
}
