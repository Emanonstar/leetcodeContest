import java.util.*;

class Solution4 {
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (a1, a2) -> a2[0] - a1[0]);
        long ans = 0, prof = 0;
        Set<Integer> distinctCate = new HashSet<>();
        List<Integer> dup = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            int[] item = items[i];
            if (i < k) {
                if (distinctCate.contains(item[1])) {
                    dup.add(item[0]);
                }
                prof += item[0];
            } else {
                if (dup.isEmpty()) break;
                if (!distinctCate.contains(item[1])) {
                    prof += item[0] - dup.remove(dup.size() - 1);
                }
            }
            distinctCate.add(item[1]);
            ans = Math.max(ans, prof + (long) distinctCate.size() * distinctCate.size());
        }
        return ans;
    }
}
