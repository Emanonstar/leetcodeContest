import java.util.*;

class Solution3 {
    Map<Integer, List<Integer>> map;

    public int minimumOperations(TreeNode root) {
        map = new HashMap<>();
        BFS(root, 0);
        int ans = 0;
        for (int h: map.keySet()) {
            List<Integer> list = map.get(h);
            Node[] target = new Node[list.size()];
            for (int i = 0; i < list.size(); i++) {
                target[i] = new Node(list.get(i), i);
            }
            Arrays.sort(target);
            boolean[] marked = new boolean[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Node n = target[i];
                int len = 0;
                while (!marked[n.pos]) {
                    marked[n.pos] = true;
                    n = target[n.pos];
                    len += 1;
                }
                ans += Integer.max(0, len - 1);
            }
        }
        return ans;
    }

    private void BFS(TreeNode node, int h) {
        if (node == null) {
            return;
        }

        if (map.containsKey(h)) {
            map.get(h).add(node.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            map.put(h, list);
        }
        BFS(node.left, h + 1);
        BFS(node.right, h + 1);
    }

    static class Node implements Comparable<Node> {
        int val;
        int pos;

        Node (int v, int p) {
            val = v;
            pos = p;
        }

        @Override
        public int compareTo(Node n) {
            return this.val - n.val;
        }
    }

     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
