class Solution2 {
    public int secondsToRemoveOccurrences(String s) {
        int l = s.length();
        char[] array = s.toCharArray();
        int rst = 0;
        while (true) {
            boolean flag = false;
            for (int i = 0; i < l - 1; i++) {
                char c1 = array[i];
                char c2 = array[i + 1];
                if (c1 == '0' && c2 == '1') {
                    array[i] = '1';
                    array[i + 1] = '0';
                    flag = true;
                    i += 1;
                }
            }
            if (!flag) {
                return rst;
            }
            rst += 1;
        }
    }
}
