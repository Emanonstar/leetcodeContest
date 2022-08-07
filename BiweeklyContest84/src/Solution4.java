class Solution4 {
    public long minimumReplacement(int[] nums) {
        int l = nums.length;
        long rst = 0;
        int min = nums[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            int num = nums[i];
            if (num > min) {
                int add;
                if (num % min == 0) {
                    add = num / min - 1;
                } else {
                    add = num / min;
                }
                min = num / (add + 1);
                rst += add;
            } else {
                min = num;
            }
        }
        return rst;
    }
}
