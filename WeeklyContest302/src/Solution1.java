import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        int n = 0, left = 0;
        for (int num : map.keySet()) {
            int count = map.get(num);
            n += count / 2;
            left += count % 2;
        }
        int[] ans = {n, left};
        return ans;
    }
}