import java.util.List;

class Solution2 {
    public boolean canSplitArray(List<Integer> nums, int m) {
        int l = nums.size();
        if (l <= 2) return true;
        for (int i = 0; i < l - 1; i++) {
            if (nums.get(i) + nums.get(i + 1) >= m) return true;
        }
        return false;
    }
}
