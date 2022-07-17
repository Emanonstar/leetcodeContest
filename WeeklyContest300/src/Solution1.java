import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public String decodeMessage(String key, String message) {
        String nkey = "";
        Map<Character, Character> table = new HashMap<>();
        for (int j = 0; j < key.length(); j++) {
            char c = key.charAt(j);
            if (c == ' ') {
                continue;
            }
            nkey += c;
        }
        int count = 0;
        for (int j = 0; j < nkey.length(); j++) {
            char c = nkey.charAt(j);
            if (c == ' ') {
                continue;
            }
            if (!table.containsKey(c)) {
                table.put(c, (char) ((j - count) % 26 + 'a'));
            } else {
                count++;
            }
        }
        String rst = "";
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == ' ') {
                rst += ' ';
                continue;
            }
            rst += table.get(c);
        }
        return rst;
    }
}
