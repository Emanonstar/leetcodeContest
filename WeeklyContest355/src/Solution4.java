import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution4 {
    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = parent.size();
        int[] mem = new int[n];
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int mask = dp(mem, parent, s, i);
            ans += map.getOrDefault(mask, 0);
            for (int j = 0; j < 26; j++) {
                ans += map.getOrDefault(mask ^ (1 << j), 0);
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        return ans;
    }

    private int dp(int[] mem, List<Integer> parent, String s, int i) {
        if (i > 0 && mem[i] == 0) {
            mem[i] = dp(mem, parent, s, parent.get(i)) ^ (1 << (s.charAt(i) - 'a'));
        }
        return mem[i];
    }
}
