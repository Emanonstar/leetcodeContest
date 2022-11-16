import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution1 {
    public int distinctAverages(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < l / 2; i++) {
            set.add(nums[i] + nums[l - 1 - i]);
        }
        return set.size();
    }
}
