import java.util.ArrayList;
import java.util.List;

class Solution3 {
    List<TreeNode>[] lists;
    List<Integer>[] vals;
    public TreeNode reverseOddLevels(TreeNode root) {
        lists = new List[15];
        vals = new List[15];
        for (int i = 0; i < 15; i++) {
            lists[i] = new ArrayList<>();
            vals[i] = new ArrayList<>();
        }
        helper(root, 0);
        for (int i = 0; i < 15; i++) {
            int l = lists[i].size();
            for (int j = 0; j < l; j++) {
                lists[i].get(j).val = vals[i].get(l - 1 - j);
            }
        }
        return root;
    }

    private void helper(TreeNode t, int level) {
        if (t == null) {
            return;
        }
        if (level % 2 != 0) {
            lists[level].add(t);
            vals[level].add(t.val);
        }
        helper(t.left, level + 1);
        helper(t.right, level + 1);
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
