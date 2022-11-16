import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution4 {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        robot.sort(Comparator.naturalOrder());
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        long[][][] a = new long[robot.size()][factory.length][100];
        for (int i = 0; i < robot.size(); i++) {
            for (int j = 0; j < factory.length; j++) {
                Arrays.fill(a[i][j], -1);
            }
        }
        return helper(robot, factory, a, 0, 0, 0);
    }

    private long helper(List<Integer> robot, int[][] factory, long[][][] a ,int i, int j, int k) {
        int l1 = robot.size();
        int l2 = factory.length;
        if (i == l1) {
            return 0;
        }
        if (j == l2) {
            return Long.MAX_VALUE;
        }
        if (a[i][j][k] != -1) {
            return a[i][j][k];
        }

        long ans1, ans2;
        if (k >= factory[j][1]) {
            ans1 = Long.MAX_VALUE;
        } else {
            ans1 = Math.abs(robot.get(i) - factory[j][0]) + helper(robot, factory, a, i + 1, j, k + 1);
        }

        ans2 = helper(robot, factory, a, i, j + 1, 0);
        if (ans1 < 0) {
            a[i][j][k] = ans2;
        } else {
            a[i][j][k] = Long.min(ans1, ans2);
        }
        return a[i][j][k];
    }
}