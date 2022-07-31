import java.util.Arrays;

class Solution2 {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int n = grades.length;
        int l = n;
        int rst = 0;
        for (int i = 1; i < n; i++) {
            l = l - i;
            if (l < 0) {
                break;
            }
            rst += 1;
        }
        return rst;
    }
}
