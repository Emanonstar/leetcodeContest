class Solution1 {
    public boolean strongPasswordCheckerII(String password) {
        int l = password.length();
        if (l < 8) {
            return false;
        }
        boolean c1 = false;
        boolean c2 = false;
        boolean c3 = false;
        boolean c4 = false;
        String s = "!@#$%^&*()-+";
        char last = ' ';
        for (int i = 0; i < l; i++) {
            char c = password.charAt(i);
            if (c - 'A' >= 0 && c - 'A' < 26) {
                c1 = true;
            }
            if (c - 'a' >= 0 && c - 'a' < 26) {
                c2 = true;
            }
            if (c - '0' >= 0 && c - '0' < 10) {
                c3 = true;
            }
            for (char cc : s.toCharArray()) {
                if (cc == c) {
                    c4 = true;
                }
            }
            if (c == last) {
                return false;
            }
            last = c;
        }
        return c1 && c2 && c3 && c4;
    }
}
