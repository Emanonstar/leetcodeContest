import java.util.Set;

class Solution1 {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int ans = 0;
        for (int i = left; i <= right; i++) {
            String w = words[i];
            if (vowels.contains(w.charAt(0)) && vowels.contains(w.charAt(w.length()- 1))) ans += 1;
        }
        return ans;
    }
}
