class Solution1 {
    public int unequalTriplets(int[] nums) {
        int l = nums.length;
        int ans = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {

                if (nums[i] != nums[j]) {
                    for (int k = j + 1; k < l; k++) {
                        if (nums[k] != nums[i] && nums[k] != nums[j]) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
