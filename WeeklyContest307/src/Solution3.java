import java.util.*;

class Solution3 {
    Map<Integer, List<Integer>> map;
    boolean[] marked;

    public int amountOfTime(TreeNode root, int start) {
        map = new HashMap<>();
        addToMap(root);
        marked = new boolean[100001];
        return DFS(start, 0);
    }

    private int DFS(int s, int h) {
        marked[s] = true;
        int rst = h;
        if (map.containsKey(s)) {
            for (int v: map.get(s)) {
                if (!marked[v]) {
                    rst = Integer.max(rst, DFS(v, h + 1));
                }
            }
        }
        return rst;
    }
    private void addToMap(TreeNode root) {
        if (root.left == null && root.right == null) {
            return;
        }
        int v1 = root.val;
        if (root.right != null) {
            int v2 = root.right.val;
            addHelper(v1, v2);
            addHelper(v2, v1);
            addToMap(root.right);
        }
        if (root.left != null) {
            int v2 = root.left.val;
            addHelper(v1, v2);
            addHelper(v2, v1);
            addToMap(root.left);
        }
    }

    private void addHelper(int v1, int v2) {
        if (map.containsKey(v1)) {
            map.get(v1).add(v2);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(v2);
            map.put(v1, list);
        }
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
}