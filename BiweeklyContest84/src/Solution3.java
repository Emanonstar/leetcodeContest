import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public long taskSchedulerII(int[] tasks, int space) {
        int l = tasks.length;
        Map<Integer, Integer> lastIndexOf = new HashMap<>();
        long[] days = new long[l];
        days[0] = 1;
        lastIndexOf.put(tasks[0], 0);
        for (int i = 1; i < l; i++) {
            int task = tasks[i];
            if (lastIndexOf.keySet().contains(task)) {
                days[i] = Long.max(days[lastIndexOf.get(task)] + space + 1, days[i - 1] + 1);
            } else {
                days[i] = days[i - 1] + 1;
            }
            lastIndexOf.put(task, i);
        }
        return days[l - 1];
    }
}
