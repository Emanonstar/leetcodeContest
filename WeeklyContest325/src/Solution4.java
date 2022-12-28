class Solution4 {
    public int countPartitions(int[] nums, int k) {
        int mol = 1000000007;
        int l = nums.length;
        long[][] sumEqualTo = new long[2][k];
        sumEqualTo[1][0] = 1;
        long sum = 0;
        for (int num: nums) {
            sum += num;
            System.arraycopy(sumEqualTo[1], 0, sumEqualTo[0], 0, k);
            for (int i = num; i < k; i++) {
                sumEqualTo[1][i] = (sumEqualTo[0][i] + sumEqualTo[0][i - num]) % mol;
            }
        }
        long sub = 0;
        for (int i = 0; i < k; i++) {
            long cnt = sumEqualTo[1][i];
            if (sum - i < k) {
                sub = (sub + cnt) % mol;
            } else {
                sub = (sub +  2 * cnt) % mol;
            }
        }

        long total = 1;
        for (int i = 0; i < l; i++) {
            total = (2 * total) % mol;
        }
        return (int)(((total - sub) % mol + mol) % mol);
    }
}
