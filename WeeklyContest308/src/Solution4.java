import java.util.*;

class Solution4 {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        int[] rowDegree = new int[k + 1];
        int[] colDegree = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            rowMap.put(i, new ArrayList<>());
            colMap.put(i, new ArrayList<>());
            rowDegree[i] = 0;
            colDegree[i] = 0;
        }
        for (int[] rowCon: rowConditions) {
            rowMap.get(rowCon[0]).add(rowCon[1]);
            rowDegree[rowCon[1]] += 1;
        }
        for (int[] colCon: colConditions) {
            colMap.get(colCon[0]).add(colCon[1]);
            colDegree[colCon[1]] += 1;
        }

        List<Integer> rowOrder = new ArrayList<>();
        List<Integer> colOrder = new ArrayList<>();
        topologicalSort(rowMap, rowDegree, rowOrder);
        topologicalSort(colMap, colDegree, colOrder);
        if (rowOrder.size() != k || colOrder.size() != k) {
            return new int[0][];
        }

        int[][] ans = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                ans[i][j] = 0;
            }
        }
        int[] row = new int[k + 1];
        int[] col = new int[k + 1];
        for (int i = 0; i < k; i++) {
            row[rowOrder.get(i)] = i;
            col[colOrder.get(i)] = i;
        }
        for (int i = 1; i <= k; i++) {
            ans[row[i]][col[i]] = i;
        }
        return ans;
    }

    private void topologicalSort(Map<Integer, List<Integer>> map, int[] degree, List<Integer> list) {
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0) {
                list.add(i);
            }
        }
        int head = 0;
        while (head < list.size()) {
            int s = list.get(head);
            head += 1;
            for (int v : map.get(s)) {
                degree[v] -= 1;
                if (degree[v] == 0) {
                    list.add(v);
                }
            }
        }
    }

//    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
//        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
//        Map<Integer, Set<Integer>> colMap = new HashMap<>();
//        for (int i = 1; i <= k; i++) {
//            rowMap.put(i, new HashSet<>());
//            colMap.put(i, new HashSet<>());
//        }
//        for (int[] rowCon: rowConditions) {
//            rowMap.get(rowCon[0]).add(rowCon[1]);
//        }
//        for (int[] colCon: colConditions) {
//            colMap.get(colCon[0]).add(colCon[1]);
//        }
//
//        boolean[][] rowMarked = new boolean[k + 1][k + 1];
//        boolean[][] colMarked = new boolean[k + 1][k + 1];
//        for (int i = 0; i < k + 1; i++) {
//            for (int j = 0; j < k + 1; j++) {
//                rowMarked[i][j] = false;
//                colMarked[i][j] = false;
//            }
//        }
//
//        for (int i = 1; i <= k; i++) {
//            if (!vallid(i, i, rowMap, rowMarked) || !vallid(i, i, colMap, colMarked)) {
//                return new int[0][];
//            }
//        }
//
//        int[][] ans = new int[k][k];
//        for (int i = 0; i < k; i++) {
//            for (int j = 0; j < k; j++) {
//                ans[i][j] = 0;
//            }
//        }
//        List<Integer> rowOrder = new ArrayList<>();
//        List<Integer> colOrder = new ArrayList<>();
//        for (int i = 1; i <= k; i++) {
//            if (!rowMarked[0][i]) {
//                DFS(i, rowMap, rowMarked, rowOrder);
//            }
//            if (!colMarked[0][i]) {
//                DFS(i, colMap, colMarked, colOrder);
//            }
//        }
//        Collections.reverse(rowOrder);
//        Collections.reverse(colOrder);
//        int[] row = new int[k + 1];
//        int[] col = new int[k + 1];
//
//        for (int i = 0; i < k; i++) {
//            row[rowOrder.get(i)] = i;
//            col[colOrder.get(i)] = i;
//        }
//
//        for (int i = 1; i <= k; i++) {
//            ans[row[i]][col[i]] = i;
//        }
//        return ans;
//    }
//
//    private boolean vallid(int s, int o, Map<Integer, Set<Integer>> map, boolean[][] marked) {
//        marked[o][s] = true;
//        for (int v: map.get(s)) {
//            if (v == o) {
//                return false;
//            }
//            if (!marked[o][v] && !vallid(v, o, map, marked)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void DFS(int s, Map<Integer, Set<Integer>> map, boolean[][] marked, List<Integer> order) {
//        marked[0][s] = true;
//        for (int v: map.get(s)) {
//            if (!marked[0][v]) {
//                DFS(v, map, marked, order);
//            }
//        }
//        order.add(s);
//    }
}
