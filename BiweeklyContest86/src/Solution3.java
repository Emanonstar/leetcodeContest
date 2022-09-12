import java.util.HashMap;
import java.util.Map;

class Solution3 {
    Map<Integer, Integer> map;
    public int maximumRows(int[][] mat, int cols) {
        map = new HashMap<>();
        return helper(mat, cols, 0, 0);
    }

    public int helper(int[][] mat, int cols, int k, int s) {
        if (k == cols) {
            int n = mat[0].length;
            int rst = 0;
            for (int[] row: mat) {
                boolean flag = true;
                for (int i = 0; i < n; i++) {
                    if ((s & (1 << i)) == 0 && row[i] == 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    rst += 1;
                }
            }
            return rst;
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        int n = mat[0].length;
        int rst = -1;
        for (int i = 0; i < n; i++) {
            if ((s & (1 << i)) == 0) {
                int ns = s | (1 << i);
                int tmp = helper(mat, cols, k + 1, ns);
                map.put(s, tmp);
                rst = Integer.max(rst, tmp);
            }
        }
        return rst;
    }
}
