import java.util.PriorityQueue;

class Solution3 {
    public long totalCost(int[] costs, int k, int candidates) {
        int l = costs.length;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int left, right;
        for (left = 0; left < candidates; left++) {
            pq.add(new Node(costs[left], left));
        }

        for (right = l - 1; right >= l - candidates && right > left; right--) {
            pq.add(new Node(costs[right], right));
        }

        long ans = 0;
        for (int i = 0; i < k; i++) {
            Node n = pq.poll();
            ans += n.val;
            if (n.pos < left && left <= right) {
                pq.add(new Node(costs[left], left));
                left += 1;
            }

            if (n.pos > right && right >= left) {
                pq.add(new Node(costs[right], right));
                right -= 1;
            }
        }
        return ans;
    }

    static class Node implements Comparable<Node> {
        int val;
        int pos;

        Node(int v, int p) {
            val = v;
            pos = p;
        }

        @Override
        public int compareTo(Node n) {
            if (this.val == n.val) {
                return this.pos - n.pos;
            }
            return this.val - n.val;
        }
    }
}
