class Solution1 {
    public int averageValue(int[] nums) {
        long sum = 0;
        int cnt = 0;
        for (int num: nums) {
            if (num % 2 == 0 && num % 3 == 0) {
                sum += num;
                cnt += 1;
            }
        }
        if (cnt == 0) {
            return 0;
        } else {
            return (int)(sum / cnt);
        }
    }
}
