import java.util.ArrayList;
import java.util.List;

class Solution3 {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int[] lengthOfNonInc = new int[n];
        int[] lengthOfNonDec = new int[n];

        lengthOfNonInc[1] = 1;
        for (int i = 2; i < n - k; i++) {
            if (nums[i - 1] <= nums[i - 2]) {
                lengthOfNonInc[i] = lengthOfNonInc[i - 1] + 1;
            } else {
                lengthOfNonInc[i] = 1;
            }
        }

        lengthOfNonDec[n - 2] = 1;
        for (int i = n - 3; i >= k; i--) {
            if (nums[i + 1] <= nums[i + 2]) {
                lengthOfNonDec[i] = lengthOfNonDec[i + 1] + 1;
            } else {
                lengthOfNonDec[i] = 1;
            }
        }

        for (int i = k; i < n - k; i++) {
            if (lengthOfNonDec[i] >= k && lengthOfNonInc[i] >= k) {
                list.add(i);
            }
        }
        return list;
    }
}
