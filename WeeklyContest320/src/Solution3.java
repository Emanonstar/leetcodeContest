import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution3 {
    Map<Integer, List<Integer>> neighbors;
    boolean[] marked;
    long ans;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        marked = new boolean[n];
        neighbors = new HashMap<>();
        for (int i = 0; i < n; i++) {
            neighbors.put(i, new ArrayList<>());
        }
        for (int[] road: roads) {
            neighbors.get(road[0]).add(road[1]);
            neighbors.get(road[1]).add(road[0]);
        }
        ans = 0;
        helper(0, seats);
        return ans;
    }

    private int helper(int s, int seats) {
        int people = 1;
        marked[s] = true;
        for (int v: neighbors.get(s)) {
            if (!marked[v]) {
                people += helper(v, seats);
            }
        }
        if (s != 0) {
            ans += people / seats;
            if (people % seats != 0) {
                ans += 1;
            }
        }
        return people;
    }
}
