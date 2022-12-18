import java.util.Set;
import java.util.TreeSet;

class Solution1 {
    public int similarPairs(String[] words) {
        int l = words.length;
        Set<Character>[] chars = new Set[l];
        for (int i = 0; i < l; i++) {
            String word = words[i];
            int ll = word.length();
            Set<Character> s = new TreeSet<>();
            for (int j = 0; j < ll; j++) {
                s.add(word.charAt(j));
            }
            chars[i] = s;
        }

        int ans = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (chars[i].containsAll(chars[j]) && chars[j].containsAll(chars[i])) {
                    ans += 1;
                }
            }
        }
        return ans;
    }
}
