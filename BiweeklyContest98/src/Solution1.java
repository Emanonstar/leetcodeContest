class Solution1 {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char c1 = '0';
        char c2 = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                c1 = s.charAt(i);
                break;
            }
        }
        String max = "";
        String min = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c1) {
                max += '9';
            } else {
                max += s.charAt(i);
            }
            if (s.charAt(i) == c2) {
                min += '0';
            } else {
                min += s.charAt(i);
            }
        }
        return Integer.valueOf(max) - Integer.valueOf(min);
    }
}
