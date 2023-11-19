import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution4 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length, l = queries.length;
        int[] ans = new int[l];
        List<int[]>[] que = new List[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[0] - a2[0]);
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) que[i] = new ArrayList<>();
        for (int qi = 0; qi < l; qi++) {
            int i = queries[qi][0], j = queries[qi][1];
            if (i < j && heights[i] < heights[j]) {
                ans[qi] = j;
            } else if (i > j && heights[i] > heights[j]) {
                ans[qi] = i;
            } else if (i == j) {
                ans[qi] = i;
            } else {
                que[Math.max(i, j)].add(new int[]{Math.max(heights[i], heights[j]), qi});
            }
        }

        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek()[0] < heights[i]) {
                int[] a = pq.poll();
                ans[a[1]] = i;
            }
            for (int[] a: que[i]) pq.add(a);
        }
        return ans;
    }
}