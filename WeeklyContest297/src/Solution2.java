import java.util.Arrays;

class Solution2 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[] costs = Arrays.copyOf(grid[0], grid[0].length);
        for (int r = 1; r < grid.length; r++) {
            int[] last = grid[r - 1];
            int[] newCosts = new int[costs.length];
            for (int i = 0; i < costs.length; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < last.length; j++) {
                    int cost = moveCost[last[j]][i] + costs[j];
                    if (cost < min) {
                        min = cost;
                    }
                }
                newCosts[i] = min + grid[r][i];
            }
            costs = newCosts;
        }
        int min = Integer.MAX_VALUE;
        for (int n : costs) {
            if (n < min) {
                min = n;
            }
        }
        return min;
    }
}
