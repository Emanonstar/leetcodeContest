class Solution2 {
    public String largestPalindromic(String num) {
        int l = num.length();
        int[] digits = new int[10];

        for (int i = 0; i < l; i++) {
            int index = num.charAt(i) - '0';
            digits[index] += 1;
        }
        String rst = "";
        for (int i = 9; i > 0; i--) {
            char c = (char) ('0' + i);
            while (digits[i] > 1) {
                rst += c;
                digits[i] -= 2;
            }
        }

        if (!rst.equals("")) {
            while (digits[0] > 1) {
                rst += '0';
                digits[0] -= 2;
            }
        }

        char[] half = rst.toCharArray();
        int ll = half.length;
        for (int i = 0; i < ll / 2; i++) {
            char tmp = half[i];
            half[i] = half[ll - 1 - i];
            half[ll - 1 - i] = tmp;
        }

        for (int i = 9; i >= 0; i--) {
            char c = (char) ('0' + i);
            if (digits[i] > 0) {
                rst += c;
                break;
            }
        }
        return rst + String.valueOf(half);
    }
}
