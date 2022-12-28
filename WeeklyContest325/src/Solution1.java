import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        List<Integer> endIndex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                endIndex.add(i);
            }
        }

        if (endIndex.isEmpty()) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        for (int end: endIndex) {
            int diff = Math.abs(startIndex - end);
            ans = Math.min(ans, Math.min(diff, n - diff));
        }
        return ans;
    }
}
