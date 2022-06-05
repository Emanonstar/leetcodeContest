import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> set = new HashMap<>();
        for (char c : target.toCharArray()) {
            if (set.containsKey(c)) {
                set.put(c, set.get(c) + 1);
            } else {
                set.put(c, 1);
            }
        }

        Map<Character, Integer> chars = new HashMap<>();
        for (char c : set.keySet()) {
            chars.put(c, 0);
        }

        for (char c : s.toCharArray()) {
            if (chars.containsKey(c)) {
                chars.put(c, chars.get(c) + 1);
            }
        }

        int count = Integer.MAX_VALUE;
        for (char c: set.keySet()) {
            int newCount = chars.get(c) / set.get(c);
            if (newCount < count) {
                count = newCount;
            }
        }
        return count;
    }
}
