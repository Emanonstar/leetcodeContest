import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution1 {
    public char repeatedCharacter(String s) {
        Map<Character, List<Integer>> char2index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (char2index.containsKey(c)) {
                char2index.get(c).add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                char2index.put(c, l);
            }
        }
        char ans = ' ';
        int lastIndex = Integer.MAX_VALUE;
        for (char c : char2index.keySet()) {
            List<Integer> l = char2index.get(c);
            if (l.size() >= 2) {
                if (l.get(1) < lastIndex) {
                    lastIndex = l.get(1);
                    ans = c;
                }
            }
        }
        return ans;
    }
}
