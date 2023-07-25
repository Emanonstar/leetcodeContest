import java.util.Collections;
import java.util.List;


class Solution3 {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        long sum = 0;
        int k = 0;
        for (int l: usageLimits) {
            sum += l;
            if (sum >= (long) (k + 1) * (k + 2) / 2) k += 1;
        }
        return k;
    }
}
//class Solution {
//    public int maxIncreasingGroups(List<Integer> usageLimits) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int limit: usageLimits) {
//            pq.add(-limit);
//        }
//        int ans = 0;
//        while (!pq.isEmpty()) {
//            int i;
//            List<Integer> list = new ArrayList<>();
//            for (i = 0; i <= ans && !pq.isEmpty(); i++) {
//                int next = -pq.poll();
//                next -= 1;
//                if (next > 0) list.add(-next);
//            }
//            if (i == ans + 1) {
//                ans += 1;
//                for (int ii: list) pq.add(ii);
//            }
//        }
//        return ans;
//    }
//}
