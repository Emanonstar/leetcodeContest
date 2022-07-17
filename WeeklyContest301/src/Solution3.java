class Solution3 {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') {
                i += 1;
            }
            while (j < n && target.charAt(j) == '_') {
                j += 1;
            }
            if (i == n || j == n) {
                break;
            }
            char p1 = start.charAt(i), p2 = target.charAt(j);
            if (p1 != p2) {
                return false;
            }
            if (p1 == 'L' && i < j) {
                return false;
            }
            if (p1 == 'R' && i > j) {
                return false;
            }
            i += 1;
            j += 1;
        }

        while (i < n) {
            if (start.charAt(i) != '_') {
                return false;
            }
            i += 1;
        }
        while (j < n) {
            if (target.charAt(j) != '_') {
                return false;
            }
            j += 1;
        }
        return true;
    }
}
