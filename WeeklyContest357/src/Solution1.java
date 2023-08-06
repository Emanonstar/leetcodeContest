import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution1 {
    public String finalString(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'i') {
                Collections.reverse(list);
            } else {
                list.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c: list) sb.append(c);
        return sb.toString();
    }
}
