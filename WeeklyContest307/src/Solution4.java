import java.util.Arrays;
import java.util.PriorityQueue;

class Solution4 {
    public long kSum(int[] nums, int k) {
        int l = nums.length;
        long[] absNums = new long[l];
        long maxNum = 0;
        for (int i = 0; i < l; i++) {
            int n = nums[i];
            if (n > 0) {
                maxNum += n;
            }
            if (n < 0) {
                n = -n;
            }
            absNums[i] = n;
        }
        Arrays.sort(absNums);
        PriorityQueue<Tuple> maxPQ = new PriorityQueue<>();
        PriorityQueue<Long> minPQ = new PriorityQueue<>();
        minPQ.add(maxNum);
        maxPQ.add(new Tuple(maxNum - absNums[0], 0));

        while (minPQ.size() < k) {
            Tuple t = maxPQ.poll();
            long val = t.val;
            int pos = t.pos;
            minPQ.add(val);
            if (pos + 1 < l) {
                maxPQ.add(new Tuple(val - absNums[pos + 1], pos + 1));
                maxPQ.add(new Tuple(val + absNums[pos] - absNums[pos + 1], pos + 1));
            }
        }
        return minPQ.poll();
    }

    private static class Tuple implements Comparable<Tuple> {
        long val;
        int pos;

        Tuple(long v, int p) {
            val = v;
            pos = p;
        }

        @Override
        public int compareTo(Tuple t) {
            if (t.val < val) {
                return -1;
            } else if (t.val == val) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
