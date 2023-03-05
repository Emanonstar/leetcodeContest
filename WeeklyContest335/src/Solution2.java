import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution2 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Long> map = new HashMap<>();
        DFS(root, map, 0);
        if (map.keySet().size() < k) {
            return -1;
        }
        for (int d: map.keySet()) {
            pq.add(map.get(d));
        }
        long ans = -1;
        for (int i = 0; i < k; i++) {
            ans = pq.poll();
        }
        return ans;
    }

    private void DFS(TreeNode node, Map<Integer, Long> map, int depth) {
        if (node == null) return;
        long sum = map.getOrDefault(depth, 0L);
        sum += node.val;
        map.put(depth, sum);
        DFS(node.left, map, depth + 1);
        DFS(node.right, map, depth + 1);
    }
}
