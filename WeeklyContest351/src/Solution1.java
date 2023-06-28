class Solution1 {
    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            int x = nums[i];
            while (x >= 10) {
                x = x / 10;
            }
            for (int j = i + 1; j < l; j++) {
                int y = nums[j] % 10;
                boolean flag = true;
                for (int k = 2; k < 10; k++) {
                    if (x % k == 0 && y % k == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) ans += 1;
            }
        }
        return ans;
    }
}
