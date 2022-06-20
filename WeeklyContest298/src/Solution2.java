class Solution2 {
    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }

        int cnt = -1;
        for (int i = 1; i <= 10; i++) {
            if ((k * i) % 10 == num % 10) {
                cnt = i;
                break;
            }
        }

        if (k * cnt > num) {
            return -1;
        }
        return cnt;
    }
}
