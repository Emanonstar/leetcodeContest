class Solution3 {
    public boolean sumOfNumberAndReverse(int num) {
        boolean ans = false;
        for (int n = 0; n <= num; n++) {
            String s = String.valueOf(n);
            StringBuffer ns = new StringBuffer();
            for (int i = s.length() - 1; i >= 0; i--) {
                ns.append(s.charAt(i));
            }
            if (n + Integer.valueOf(ns.toString()) == num) {
                ans = true;
                break;
            }
        }
        return ans;
    }
}
