import java.util.HashMap;
import java.util.Map;

class Solution4 {
    Map<Integer, Integer> heightRootAt;
    Map<Integer, Integer> rst;
    int height;
    public int[] treeQueries(TreeNode root, int[] queries) {
        heightRootAt = new HashMap<>();
        rst = new HashMap<>();
        height = DFS1(root) - 1;
        System.out.println(height);
        DFS2(root, 0, 0);
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = rst.get(queries[i]);
        }
        return ans;
    }

    private int DFS1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int h = Integer.max(DFS1(node.left), DFS1(node.right));
        heightRootAt.put(node.val, h);
        return h + 1;
    }

    private void DFS2(TreeNode node, int possibleHeight, int dis) {
        if (node == null) {
            return;
        }

        int h = heightRootAt.get(node.val) + 1;
        rst.put(node.val, Integer.max(height - h, possibleHeight));
        if (node.right == null) {
            DFS2(node.left, possibleHeight, dis + 1);
        } else {
            DFS2(node.left, Integer.max(heightRootAt.get(node.right.val) + dis + 1, possibleHeight), dis + 1);
        }
        if (node.left == null) {
            DFS2(node.right, possibleHeight, dis + 1);
        } else {
            DFS2(node.right, Integer.max(heightRootAt.get(node.left.val) + dis + 1, possibleHeight), dis + 1);
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
