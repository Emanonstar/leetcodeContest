import java.util.HashMap;
import java.util.Map;

class Solution4 {
    public int countSubarrays(int[] nums, int k) {
        int l = nums.length;
        int[] largerK = new int[l];
        int index = 0;
        for (int i = 0; i < l; i++) {
            if (nums[i] == k) {
                index = i;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int diff = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] > k) {
                diff += 1;
            } else {
                diff -= 1;
            }
            if (map.containsKey(diff)) {
                map.put(diff, map.get(diff) + 1);
            } else {
                map.put(diff, 1);
            }
        }
        int ans = 0;
        diff = 0;
        if (map.containsKey(-diff)) {
            ans += map.get(-diff);
        }
        if (map.containsKey(-diff + 1)) {
            ans += map.get(-diff + 1);
        }
        for (int i = index + 1; i < l; i++) {
            if (nums[i] > k) {
                diff += 1;
            } else {
                diff -= 1;
            }
            if (map.containsKey(-diff)) {
                ans += map.get(-diff);
            }
            if (map.containsKey(-diff + 1)) {
                ans += map.get(-diff + 1);
            }
        }
        return ans;
    }
}
