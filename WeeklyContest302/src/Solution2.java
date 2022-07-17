import java.util.*;

class Solution2 {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int n : nums) {

            int sum = 0;
            int num = n;
            while (num != 0) {
                sum += num % 10;
                num = num / 10;
            }

            if (!map.containsKey(sum)) {
                List<Integer> l = new ArrayList<>();
                l.add(n);
                map.put(sum, l);
            } else {
                map.get(sum).add(n);
            }
        }

        int max = -1;

        for (int i : map.keySet()) {
            List<Integer> l = map.get(i);
            if (l.size() > 1) {
                Collections.sort(l);
                Collections.reverse(l);
                int sum = l.get(0) + l.get(1);
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
