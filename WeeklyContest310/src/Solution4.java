class Solution4 {
    public int lengthOfLIS(int[] nums, int k) {
        int l = nums.length;
        int[] f = new int[l];
        int max = -1;
        for (int n: nums) {
            max = Math.max(max, n);
        }
        SegmentTree segmentTree = new SegmentTree(max + 1);
        segmentTree.changeValue(1, nums[0]);
        for (int i = 1; i < l; i++) {
            int n = segmentTree.findMax(Math.max(0, nums[i] - k), nums[i] - 1) + 1;
            f[i] = n;
            segmentTree.changeValue(n, nums[i]);
        }
        int ans = 1;
        for (int i = 0; i < l; i++) {
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }


    static class SegmentTree {
        Node root;

        public SegmentTree(int l) {
            root = new Node(0, 0, l - 1);
            if (l != 1) {
                root.leftTree = init(0, (l - 1) / 2);
                root.rightTree = init((l - 1) / 2 + 1, l - 1);
            }
        }

        private Node init(int l, int r) {
            Node n = new Node(0, l, r);
            if (l == r) {
                return n;
            }
            int m = (l + r) / 2;
            n.leftTree = init(l, m);
            n.rightTree = init(m + 1, r);
            return n;
        }

        public int findMax(int l, int r) {
            return findHelper(root, l, r);
        }

        private int findHelper(Node n, int l, int r) {
            if (n.left == l && n.right == r) {
                return n.max;
            }
            int m = (n.left + n.right) / 2;
            if (l > m) {
                return findHelper(n.rightTree, l, r);
            }
            if (r <= m) {
                return findHelper(n.leftTree, l, r);
            }
            return Math.max(findHelper(n.leftTree, l, m), findHelper(n.rightTree, m + 1, r));
        }

        public void changeValue(int v, int p) {
            changeHelper(root, v, p);
        }

        private int changeHelper(Node n, int v, int p) {
            if (n.left == p && n.right == p) {
                n.max = Math.max(n.max, v);
                return n.max;
            }
            int m = (n.left + n.right) / 2;
            int newMax;
            if (p <= m) {
                newMax = changeHelper(n.leftTree, v, p);
            } else {
                newMax = changeHelper(n.rightTree, v, p);
            }
            n.max = Math.max(n.max, newMax);
            return n.max;
        }

        private static class Node {
            int max;
            int left;
            int right;
            Node leftTree;
            Node rightTree;

            public Node(int max, int left, int right) {
                this.max = max;
                this.left = left;
                this.right = right;
            }
        }
    }
}
