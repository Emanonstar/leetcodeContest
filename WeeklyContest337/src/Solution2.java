import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;
        int l = grid.length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                map.put(grid[i][j], new int[]{i, j});
            }
        }
        int[] last = new int[2];
        for (int i = 1; i < l * l; i++) {
            if (!map.containsKey(i)) return false;
            int[] pos = map.get(i);
            if (!isFit(last, pos)) return false;
            last = pos;
        }
        return true;
    }

    private boolean isFit(int[] p1, int[] p2) {
        return (Math.abs(p1[0] - p2[0]) == 1 && Math.abs(p1[1] - p2[1]) == 2)
                || (Math.abs(p1[0] - p2[0]) == 2 && Math.abs(p1[1] - p2[1]) == 1);
    }
}
