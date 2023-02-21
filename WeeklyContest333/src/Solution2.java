import java.util.HashMap;
import java.util.Map;

class Solution2 {
    Map<Integer, Integer> map;
    public int minOperations(int n) {
        int[] pow2 = new int[20];
        pow2[0] = 1;
        for (int i = 1; i < 20; i++) {
            pow2[i] = pow2[i - 1] * 2;
        }
        map = new HashMap<>();
        return helper(n, pow2);
    }

    private int helper(int n, int[] pow2) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int i;
        for (i = 0; i < 20; i++) {
            if (pow2[i] == n) {
                return 0;
            }
            if (pow2[i] > n) {
                break;
            }
        }
        int v1 = helper(pow2[i] - n, pow2);
        int v2 = helper(n - pow2[i - 1], pow2);
        map.put(n, Math.min(v1, v2) + 1);
        return map.get(n);
    }
}
