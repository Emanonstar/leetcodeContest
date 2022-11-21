import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        int l = queries.size();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> vals = new ArrayList<>();
        helper(root, vals);

        for (int i = 0; i < l; i++) {
            List<Integer> list = new ArrayList<>();
            int query = queries.get(i);
            int index = Collections.binarySearch(vals, query);
            if (index < 0) {
                index = -index - 1;
                if (index - 1 < 0) {
                    list.add(-1);
                } else {
                    list.add(vals.get(index - 1));
                }
                if (index < vals.size()) {
                    list.add(vals.get(index));
                } else {
                    list.add(-1);
                }

            } else {
                list.add(query);
                list.add(query);
            }
            ans.add(list);
        }
        return ans;
    }

    private void helper(TreeNode node, List<Integer> vals) {
        if (node == null) {
            return;
        }
        helper(node.left, vals);
        vals.add(node.val);
        helper(node.right, vals);
    }
}
