class Solution2 {
    public int appendCharacters(String s, String t) {
        int m = s.length();
        int n = t.length();
        int index = 0;
        for (int i = 0; i < m && index < n; i++) {
            if (s.charAt(i) == t.charAt(index)) {
                index += 1;
            }
        }
        return n - index;
    }
}
