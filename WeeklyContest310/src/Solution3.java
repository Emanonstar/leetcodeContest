class Solution3 {
    public int minGroups(int[][] intervals) {
        int[] a = new int[1000001];
        for (int[] interval: intervals) {
            a[interval[0]] += 1;
            a[interval[1]] -= 1;
        }
        int ans = -1;
        int cnt = 0;
        for (int i: a) {
            cnt += i;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
