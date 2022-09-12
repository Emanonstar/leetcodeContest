import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public int partitionString(String s) {
        int l = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 1;
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                ans += 1;
                set = new HashSet<>();
            }
            set.add(c);
        }
        return ans;
    }
}
