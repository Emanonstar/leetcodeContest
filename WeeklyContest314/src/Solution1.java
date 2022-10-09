class Solution1 {
    public int hardestWorker(int n, int[][] logs) {
        int maxTime = -1;
        int ans = 0;
        int lastBegin = 0;
        for (int[] log: logs) {
            int tmp = log[1] - lastBegin;
            if (tmp > maxTime) {
                maxTime = tmp;
                ans = log[0];
            } else if (tmp == maxTime) {
                ans = Integer.min(ans, log[0]);
            }
            lastBegin = log[1];
        }
        return ans;
    }
}
