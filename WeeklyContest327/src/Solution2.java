import java.util.PriorityQueue;

class Solution2 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n: nums) {
            pq.add(-n);
        }
        long score = 0;
        for (int i = 0; i < k; i++) {
            int add = -pq.poll();
            score += add;
            if (add % 3 == 0) {
                pq.add(-(add / 3));
            } else {
                pq.add(-(add /3 + 1));
            }
        }
        return score;
    }
}
