import java.util.Arrays;

class Solution3 {
    public long minCost(int[] nums, int[] cost) {
        int l = nums.length;

        Node[] nodes = new Node[l];
        for (int i = 0; i < l; i++) {
            nodes[i] = new Node(nums[i], cost[i]);
        }
        Arrays.sort(nodes);
        long[] preSum = new long[l];
        preSum[0] = nodes[0].c;

        long tc = 0;
        for (int i = 1; i < l; i++) {
            Node n = nodes[i];
            tc += ((long) n.c * (n.n - nodes[0].n));
            preSum[i] = preSum[i - 1] + n.c;
        }
        long ans = tc;
        for (int i = 1; i < l; i++) {
            Node n = nodes[i];
            Node ln = nodes[i - 1];
            tc += (preSum[i - 1] - (long) n.c - (preSum[l - 1] - preSum[i])) * (n.n - ln.n);
            ans = Long.min(ans, tc);
        }
        return ans;
    }

    static class Node implements Comparable<Node>{
        int n;
        int c;

        Node(int num, int cost) {
            n = num;
            c = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.n - n.n;
        }
    }
}
