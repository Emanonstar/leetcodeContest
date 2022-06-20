class Solution1 {
    public String greatestLetter(String s) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c - 'a' >= 0 && c - 'a' <= 26) {
                lower[c - 'a'] = true;
            }
            if (c - 'A' >= 0 && c - 'A' <= 26) {
                upper[c - 'A'] = true;
            }
        }
        String result = "";
        for (int i = 25; i >= 0; i--) {
            if (lower[i] && upper[i]) {
                int c = 'A' + i;
                char c1 = (char)c;
                result += c1;
                return result;
            }
        }
        return result;
    }
}
