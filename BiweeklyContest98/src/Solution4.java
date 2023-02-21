import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

class Solution4 {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int l = nums1.length;
        long sum = 0;
        for (int n: nums2) sum += n;
        SegmentTree st = build(nums1, 0, l - 1);
        List<Long> list = new ArrayList<>();
        for (int[] query: queries) {
            if (query[0] == 1) st.flip(query[1], query[2]);
            else if (query[0] == 2) sum += (long) st.sum * query[1];
            else list.add(sum);
        }
        long[] rst = new long[list.size()];
        for (int i = 0; i < rst.length; i++) {
            rst[i] = list.get(i);
        }
        return rst;
    }

    private SegmentTree build(int[] nums, int l, int r) {
        if (l == r) {
            SegmentTree node = new SegmentTree(l, r);
            node.sum = nums[l];
            return node;
        }
        int mid = (l + r) / 2;
        SegmentTree left = build(nums, l, mid), right = build(nums, mid + 1, r);
        SegmentTree root = new SegmentTree(l, r);
        root.sum = left.sum + right.sum;
        root.left = left;
        root.right = right;
        return root;
    }

    static class SegmentTree {
        int sum;
        int f, lo, hi;
        SegmentTree left;
        SegmentTree right;

        SegmentTree(int l, int r) {
            lo = l;
            hi = r;
        }

        void flip(int l, int r) {
            if (l > hi || r < lo) return;
            if (l <= lo && hi <= r) {
                f ^= 1;
                sum = hi - lo + 1 - sum;
                return;
            }
            if (f == 1) {
                left.flip(lo, hi);
                right.flip(lo, hi);
                f ^= 1;
            }
            left.flip(l, r);
            right.flip(l, r);
            sum = left.sum + right.sum;
        }
    }

//    BitSet solution
//    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
//        int l = nums1.length;
//        BitSet bitSet = new BitSet(l);
//        for (int i = 0; i < l; i++) {
//            if (nums1[i] == 1) bitSet.set(i);
//        }
//        List<Long> list = new ArrayList<>();
//        long sum = 0;
//        for (int n: nums2) {
//            sum += n;
//        }
//        for (int[] query: queries) {
//            if (query[0] == 1) bitSet.flip(query[1], query[2] + 1);
//            else if (query[0] == 2) sum += (long) bitSet.cardinality() * query[1];
//            else list.add(sum);
//        }
//        long[] rst = new long[list.size()];
//        for (int i = 0; i < rst.length; i++) {
//            rst[i] = list.get(i);
//        }
//        return rst;
//    }
}
