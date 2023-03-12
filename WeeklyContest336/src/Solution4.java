import java.util.Arrays;

class Solution4 {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (t1, t2) -> t1[1] - t2[1]);
        boolean[] time = new boolean[2001];
        for (int[] task: tasks) {
            int st = task[0], end = task[1], d = task[2];
            for (int t = end; t >= st; t--) {
                if (time[t]) d -= 1;
            }
            for (int t = end; t >= st && d > 0; t--) {
                if (!time[t]) {
                    d -= 1;
                    time[t] = true;
                }
            }

        }
        int ans = 0;
        for (int i = 1; i < 2001; i++) {
            if (time[i]) ans += 1;
        }
        return ans;
    }
}
