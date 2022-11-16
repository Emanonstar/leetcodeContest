class Solution4 {
    public int maxPalindromes(String s, int k) {
        int l = s.length();
        boolean[][] isPalindrome = new boolean[l][l];

        for (int i = 0; i < l; i++) {
            int ll = Integer.min(i, l - 1 - i);
            for (int j = 0; j <= ll; j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    isPalindrome[i - j][i + j] = true;
                } else {
                    break;
                }
            }

            int lll = Integer.min(i, l - 1 - i - 1);
            for (int j = 0; j <= lll; j++) {
                if (s.charAt(i - j) == s.charAt(i + 1 + j)) {
                    isPalindrome[i - j][i + 1 + j] = true;
                } else {
                    break;
                }
            }
        }

        int[] f = new int[l];
        for (int i = k - 1; i < l; i++) {
            int tmp = 0;
            if (isPalindrome[0][i]) {
                tmp = 1;
            }

            for (int j = 0; j < i; j++) {
                if (i - j >= k && isPalindrome[j + 1][i]) {
                    tmp = Integer.max(tmp, f[j] + 1);
                } else {
                    tmp = Integer.max(tmp, f[j]);
                }
            }
            f[i] = tmp;
        }
        return f[l - 1];
    }
}
