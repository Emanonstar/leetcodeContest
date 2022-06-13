import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution3 {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        Map<Character, Set<Character>> maps = new HashMap<>();
        for (char[] mapping : mappings) {
            if (maps.containsKey(mapping[0])) {
                maps.get(mapping[0]).add(mapping[1]);
            } else {
                Set<Character> news = new HashSet<>();
                news.add(mapping[1]);
                maps.put(mapping[0], news);
            }
        }

        for (int i = 0; i <= s.length() - sub.length(); i++) {
            for (int j = 0; j < sub.length(); j++) {
                char cAtS = s.charAt(i + j);
                char cAtSub = sub.charAt(j);
                if (cAtSub != cAtS && (!maps.containsKey(cAtSub) || !maps.get(cAtSub).contains(cAtS))) {
                    break;
                } else if (j == sub.length() - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
