class Solution2 {
    public String smallestString(String s) {
        int l = s.length();
        StringBuffer stringBuffer = new StringBuffer();
        int begin = l;
        int end = l;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) - 'a' != 0) {
                begin = i;
                break;
            }
        }
        for (int i = begin + 1; i < l; i++) {
            if (s.charAt(i) - 'a' == 0) {
                end = i;
                break;
            }
        }
        if (begin == l) {
            return s.substring(0, l - 1) + 'z';
        }
        for (int i = 0; i < begin; i++) {
            stringBuffer.append(s.charAt(i));
        }
        for (int i = begin; i < end; i++) stringBuffer.append((char) (s.charAt(i) - 1));
        for (int i = end; i < l; i++) stringBuffer.append(s.charAt(i));
        return stringBuffer.toString();
    }
}
