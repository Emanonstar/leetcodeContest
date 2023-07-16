import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution4 {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int l = word.length();
        Set<String> forbid = new HashSet<>();
        int len = 0;
        for (String s: forbidden) {
            forbid.add(s);
            len = Math.max(len, s.length());
        }
        int ans = 0;
        for (int i = l - 1, right = l; right > ans && i >= 0; i--) {
            StringBuilder sub = new StringBuilder();
            for (int j = i; j < right && j - i < len; j++) {
                sub.append(word.charAt(j));
                if (forbid.contains(sub.toString())) {
                    right = j;
                    break;
                }
            }
            ans = Math.max(ans, right - i);
        }
        return ans;
    }
}
