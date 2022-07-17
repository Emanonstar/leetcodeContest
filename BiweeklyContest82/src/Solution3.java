import java.util.Arrays;

class Solution3 {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = k1 + k2;
        long[] diff_abs = new long[n];
        for (int i = 0; i < n; i++) {
            int dif = nums1[i] - nums2[i];
            if (dif < 0) {
                dif = - dif;
            }
            diff_abs[i] = dif;
        }

        Arrays.sort(diff_abs);
        long[] steps = new long[n];
        steps[n - 1] = diff_abs[n - 1] - diff_abs[n - 2];
        for (int i = n - 2; i > 0; i--) {
            steps[i] = steps[i + 1] + (n - i) * (diff_abs[i] - diff_abs[i - 1]);
        }
        steps[0] = steps[1] + n * diff_abs[0];

        if (k >= steps[0]) {
            return 0;
        }

        for (int i = n - 1; i > 0; i--) {
            if (steps[i] > k) {
                if (i + 1 <= n - 1) {
                    k -= steps[i + 1];
                }
                int delta = (int) (k / (n - i));
                int a = (int) (k % (n - i));
                long diff_max = diff_abs[i] - delta;
                long rst = a * (diff_max - 1) * (diff_max - 1) + (n - i - a) * diff_max * diff_max;
                for (int j = 0; j < i; j++) {
                    rst += diff_abs[j] * diff_abs[j];
                }
                return rst;
            }
        }
        k -= steps[1];
        int delta = (int) (k / n);
        int a = (int) (k % n);
        long diff_max = diff_abs[0] - delta;
        return  a * (diff_max - 1) * (diff_max - 1) + (n - a) * diff_max * diff_max;
    }
}
