class Solution2 {
    public String removeStars(String s) {
        StringBuffer sb = new StringBuffer();
        int l = s.length();
        int count = 0;
        for (int i = l - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*') {
                count += 1;
            } else {
                if (count == 0) {
                    sb.append(c);
                } else {
                    count -= 1;
                }
            }
        }
        return sb.reverse().toString();
    }
}
