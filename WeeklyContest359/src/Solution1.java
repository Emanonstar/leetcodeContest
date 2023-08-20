import java.util.List;

class Solution1 {
    public boolean isAcronym(List<String> words, String s) {
        int l = s.length();
        if (words.size() != l) return false;
        for (int i = 0; i < l; i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) return false;
        }
        return true;
    }
}
