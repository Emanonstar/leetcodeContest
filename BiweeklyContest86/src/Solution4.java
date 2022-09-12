import java.util.ArrayDeque;
import java.util.Deque;

class Solution4 {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int l = runningCosts.length;
        long[] prefixSum = new long[l];
        prefixSum[0] = runningCosts[0];
        for (int i = 1; i < l; i++) {
            prefixSum[i] = prefixSum[i - 1] + runningCosts[i];
        }

        int ans = 0, left = -1, mx;
        long sum;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < l; i++) {
            while (dq.size() !=0 && chargeTimes[dq.getLast()] < chargeTimes[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            mx = chargeTimes[dq.peekFirst()];
            sum = prefixSum[i] - (left >= 0 ? prefixSum[left] : 0);

            int k = i - left;
            long cost = mx + k * sum;

            while (left < i && cost > budget) {
                left += 1;
                if (!dq.isEmpty() && dq.peekFirst() == left) {
                    dq.removeFirst();
                }
                if (!dq.isEmpty()) {
                    mx = chargeTimes[dq.peekFirst()];
                    k = i - left;
                    sum = prefixSum[i] - prefixSum[left];
                    cost = mx + k * sum;
                }
            }

            if (cost <= budget) {
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }
}
