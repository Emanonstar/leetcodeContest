class Solution2 {
    public int takeCharacters(String s, int k) {
        int l = s.length();
        int[][] pre = new int[3][l + 1];
        for (int i = 1; i < l + 1; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == s.charAt(i - 1) - 'a') {
                    pre[j][i] = pre[j][i - 1] + 1;
                } else {
                    pre[j][i] = pre[j][i - 1];
                }
            }
        }
        int left = -1;
        for (int i = 1; i < l + 1; i++) {
            boolean flag = true;
            for (int j = 0; j < 3; j++) {
                if (pre[j][i] - pre[j][0] < k) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                left = i - 1;
                break;
            }
        }
        if (left == -1) {
            return -1;
        }
        int ans = left + 1;
        int right = l;
        while (left >= 0) {
            left -= 1;
            while (right > left  + 1 && !(isFit(pre, k, 0, left, right) && isFit(pre, k, 1, left, right) && isFit(pre, k, 2, left, right))) {
                right -= 1;
            }
            if (isFit(pre, k, 0, left, right) && isFit(pre, k, 1, left, right) && isFit(pre, k, 2, left, right)) {
                ans = Integer.min(ans, left + 1 + l - right);
            }

        }
        return ans;
    }

    private boolean isFit(int[][] pre, int k, int i, int left, int right) {
        int l = pre[i].length - 1;
        return (pre[i][l] - pre[i][right] + pre[i][left + 1] - pre[i][0]) >= k;
    }
}
