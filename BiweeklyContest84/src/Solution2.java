import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public long countBadPairs(int[] nums) {
        int l = nums.length;
        long rst = ((long) l) * (l - 1) / 2;

        Map<Integer, Long> map = new HashMap<>();

        for (int i = 0; i < l; i++) {
            int dif = i - nums[i];
            if (map.containsKey(dif)) {
                long good = map.get(dif);
                rst -= good;
                map.put(dif, good + 1);
            } else {
                map.put(dif, (long) 1);
            }
        }
        return rst;
    }
}
