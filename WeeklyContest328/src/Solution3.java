import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public long countGood(int[] nums, int k) {
        int l = nums.length;
        long goods = 0;
        long ans = 0;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            goods += map.getOrDefault(nums[i], 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (goods < k) continue;
            while (goods >= k) {
                map.put(nums[j], Integer.max(0, map.get(nums[j]) - 1));
                goods -= map.get(nums[j]);
                j += 1;
            }
            j -= 1;
            goods += map.get(nums[j]);
            map.put(nums[j], map.get(nums[j]) + 1);
            //System.out.println("from " + j + " to " + i);
            ans += (j + 1);
        }
        return ans;
    }
}
