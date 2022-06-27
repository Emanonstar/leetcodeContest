class Solution1 {
    public int countAsterisks(String s) {
        boolean flag = true;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                flag = !flag;
            }
            if (flag && c == '*') {
                count += 1;
            }
        }
        return count;
    }
}