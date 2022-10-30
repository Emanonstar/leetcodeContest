import java.util.*;

class Solution3 {
    public int destroyTargets(int[] nums, int space) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int res = num % space;
            if (map.containsKey(res)) {
                map.get(res).add(num);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                map.put(res, list);
            }
        }

        int max = 0;
        for (int k: map.keySet()) {
            max = Integer.max(max, map.get(k).size());
        }

        int ans = Integer.MAX_VALUE;
        for (int k: map.keySet()) {
            if (map.get(k).size() == max) {
                for (int a: map.get(k)) {
                    ans = Integer.min(ans, a);
                }
            }
        }
        return ans;
    }
}
