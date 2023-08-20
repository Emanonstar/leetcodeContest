import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution4 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int l = nums.size(), ans = 1, i = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int j = 0; j < l; j++) {
            cnt.put(nums.get(j), cnt.getOrDefault(nums.get(j), 0) + 1);
            ans = Math.max(ans, cnt.get(nums.get(j)));
            if (j - i + 1 - ans > k) {
                cnt.put(nums.get(i), cnt.get(nums.get(i) - 1));
                i += 1;
            }
        }
        return ans;
    }
}
