import java.util.*;

class Solution3 {
    Map<Integer, Set<Integer>> neighbors;
    int[] amount;
    boolean[] markedBob;
    boolean[] markedAlice;
    Map<Integer, Integer> pathbob;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        neighbors = new HashMap<>();
        this.amount = amount;
        markedAlice = new boolean[n];
        markedBob = new boolean[n];
        pathbob = new HashMap<>();

        for (int i = 0; i < n; i++) {
            neighbors.put(i, new HashSet<>());
        }
        for (int[] e: edges) {
            neighbors.get(e[0]).add(e[1]);
            neighbors.get(e[1]).add(e[0]);
        }

        DFSbob(bob, 0);
        return DFSalice(0, 0);
    }

    private int DFSalice(int s, int h) {
        markedAlice[s] = true;
        int ans = 0;
        if (pathbob.containsKey(s)) {
            if (h < pathbob.get(s)) {
                ans = amount[s];
            } else if (h == pathbob.get(s)) {
                ans = amount[s] / 2;
            }
        } else {
            ans = amount[s];
        }

        int add = Integer.MIN_VALUE;
        for (int v : neighbors.get(s)) {
            if (!markedAlice[v]) {
                add = Integer.max(add, DFSalice(v, h + 1));
            }
        }
        if (add == Integer.MIN_VALUE) {
            return ans;
        } else {
            return ans + add;
        }
    }

    private int DFSbob(int s, int h) {
        markedBob[s] = true;
        if (s == 0) {
            pathbob.put(s, h);
            return h;
        }

        for (int v: neighbors.get(s)) {
            if (!markedBob[v]) {
                if (DFSbob(v, h + 1) > 0) {
                    pathbob.put(s, h);
                    return h;
                }
            }
        }
        return -1;
    }
}
