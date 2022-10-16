import java.util.ArrayList;
import java.util.List;

class Solution4 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int l = nums.length;
        List<Integer> upper = new ArrayList<>();
        List<Integer> lower = new ArrayList<>();
        List<Integer> exo = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            if (nums[i] == maxK) {
                upper.add(i);
            }
            if (nums[i] == minK) {
                lower.add(i);
            }
            if (nums[i] > maxK || nums[i] < minK) {
                exo.add(i);
            }
        }

        int j = 0, k = 0, m = 0;
        for (int i = 0; i < l; i++) {
            while (j < upper.size() && upper.get(j) < i) {
                j += 1;
            }
            while (k < lower.size() && lower.get(k) < i) {
                k += 1;
            }
            while (m < exo.size() && exo.get(m) < i) {
                m += 1;
            }
            if (j < upper.size() && k < lower.size()) {
                int left = Integer.max(upper.get(j), lower.get(k));
                if (m < exo.size()) {
                    int add = exo.get(m) - left;
                    if (add > 0) {
                        ans += (exo.get(m) - left);
                    }
                } else {
                    ans += (l - left);
                }
            }
        }
        return ans;
    }
}
