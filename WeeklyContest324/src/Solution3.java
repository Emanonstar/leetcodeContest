import java.util.*;

class Solution3 {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        int[] degrees = new int[n + 1];
        Map<Integer, Set<Integer>> neibors = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            neibors.put(i, new HashSet<>());
        }
        for (List<Integer> l: edges) {
            neibors.get(l.get(0)).add(l.get(1));
            neibors.get(l.get(1)).add(l.get(0));
        }
        for (int i: neibors.keySet()) {
            degrees[i] = neibors.get(i).size();
        }

        List<Integer> nodesToFix = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (degrees[i] % 2 != 0) {
                if (degrees[i] == n - 1) {
                    return false;
                }
                nodesToFix.add(i);
            }
        }
        if (nodesToFix.size() > 4 || nodesToFix.size() % 2 != 0) {
            return false;
        }
        if (nodesToFix.size() == 4) {
            if (!neibors.get(nodesToFix.get(0)).contains(nodesToFix.get(1)) && !neibors.get(nodesToFix.get(2)).contains(nodesToFix.get(3))) {
                return true;
            } else if (!neibors.get(nodesToFix.get(0)).contains(nodesToFix.get(2)) && !neibors.get(nodesToFix.get(1)).contains(nodesToFix.get(3))) {
                return true;
            } else if (!neibors.get(nodesToFix.get(0)).contains(nodesToFix.get(3)) && !neibors.get(nodesToFix.get(1)).contains(nodesToFix.get(2))) {
                return true;
            } else {
                return false;
            }
        }

        if (nodesToFix.size() == 2) {
            if (!neibors.get(nodesToFix.get(0)).contains(nodesToFix.get(1))) {
                return true;
            } else {
                for (int i = 1; i <= n; i++) {
                    if (i != nodesToFix.get(0) && i != nodesToFix.get(1) && !neibors.get(i).contains(nodesToFix.get(0)) && !neibors.get(i).contains(nodesToFix.get(1))) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }
}
