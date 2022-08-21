import java.util.ArrayList;
import java.util.List;

class Solution4 {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        DSU dsu = new DSU(n, nums);
        List<Long> rst = new ArrayList<>();
        rst.add((long) 0);
        long max = 0;
        for (int i = n - 1; i > 0; i--) {
            max = dsu.add(removeQueries[i], max);
            rst.add(max);
        }
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            ans[i] = rst.get(n - 1 - i);
        }
        return ans;
    }

    private static class DSU {
        int[] array;
        int[] counts;
        long[] sums;

        DSU (int n, int[] nums) {
            array = new int[n];
            sums = new long[n];
            counts = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = -1;
                sums[i] = nums[i];
                counts[i] = 0;
            }
        }

        private int find(int s) {
            if (array[s] == s) {
                return s;
            }
            return find(array[s]);
        }

        public long add(int s, long max) {
            array[s] = s;
            counts[s] = 1;
            int left = s - 1;
            max = Long.max(max, sums[s]);
            if (left >= 0 && left < array.length && array[left] != -1) {
                max = Long.max(max, join(s, left));
            }

            int right = s + 1;
            if (right >= 0 && right < array.length && array[right] != -1) {
                max = Long.max(max, join(s, right));
            }
            return max;
        }

        public long join(int s, int t) {
            int r1 = find(s);
            int r2 = find(t);
            if (counts[r1] > counts[r2]) {
                array[r2] = r1;
                counts[r1] += counts[r2];
                return (sums[r1] += sums[r2]);
            } else {
                array[r1] = r2;
                counts[r2] += counts[r1];
                return (sums[r2] += sums[r1]);
            }
        }
    }
}
