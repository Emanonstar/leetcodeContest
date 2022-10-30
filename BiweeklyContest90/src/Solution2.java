import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (String s1: queries) {
            for (String s2: dictionary) {
                if (diff(s1, s2) <= 2) {
                    ans.add(s1);
                    break;
                }
            }
        }
        return ans;
    }

    private int diff(String s1, String s2) {
        int l = s1.length();
        int ans = 0;
        for (int i = 0; i < l; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ans += 1;
            }
        }
        return ans;
    }
}
