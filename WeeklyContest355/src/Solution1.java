import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        int l = words.size();
        List<String> splitWords = new ArrayList<>();
        for (String w: words) {
            String add = "";
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (c == separator) {
                    if (add.length() != 0) splitWords.add(add);
                    add = "";
                } else {
                    add += c;
                }
            }
            if (add.length() != 0) splitWords.add(add);
        }
        return splitWords;
    }
}
