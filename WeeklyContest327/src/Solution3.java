import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public boolean isItPossible(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c: word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c: word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (char c1 = 'a'; c1 <= 'z'; c1++) {
            for (char c2 = 'a'; c2 <= 'z'; c2++) {
                if (!map1.containsKey(c1) || !map2.containsKey(c2)) continue;
                insertAndRemove(map1, c2, c1);
                insertAndRemove(map2, c1, c2);
                if (map1.size() == map2.size()) return true;
                insertAndRemove(map1, c1, c2);
                insertAndRemove(map2, c2, c1);
            }
        }
        return false;
    }

    private void insertAndRemove(Map<Character, Integer> map, char toInsert, char toRemove) {
        map.put(toInsert, map.getOrDefault(toInsert, 0) + 1);
        map.put(toRemove, map.get(toRemove) - 1);
        if (map.get(toRemove) == 0) {
            map.remove(toRemove);
        }
    }
}
