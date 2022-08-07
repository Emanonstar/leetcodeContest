import java.util.HashMap;
import java.util.Map;

class Solution4 {
    public int longestIdealString(String s, int k) {
        int l = s.length();
        int[] longestEndAt = new int[l];
        Map<Character, Integer> lastPos = new HashMap<>();

        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            int low = Integer.max('a', c - k);
            int high = Integer.min('z', c + k);

            int max = 0;
            for (int j = low; j <= high; j++) {
                if (lastPos.containsKey((char) j)) {
                    max = Integer.max(max, longestEndAt[lastPos.get((char) j)]);
                }
            }
            longestEndAt[i] = max + 1;
            lastPos.put(c, i);
        }

        int rst = 1;
        for (int ll : longestEndAt) {
            rst = Integer.max(rst, ll);
        }
        return rst;
    }
}
