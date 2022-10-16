import java.util.ArrayList;
import java.util.List;

class Solution2 {
    int mol = 1000000007;
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> binary = new ArrayList<>();
        while (n != 0) {
            binary.add(n % 2);
            n = n / 2;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < binary.size(); i++) {
            if (binary.get(i) == 1) {
                list.add(i);
            }
        }

        int[] preSum = new int[list.size()];
        preSum[0] = list.get(0);
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + list.get(i);
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            int[] q = queries[i];
            int pow;
            if (q[0] == 0) {
                pow = preSum[q[1]];
            } else {
                pow = preSum[q[1]] - preSum[q[0] - 1];
            }
            ans[i] = (int) (twoPow(pow) % mol);
        }
        return ans;
    }

    private long twoPow(int x) {
        if (x == 0) {
            return 1;
        }

        long a = twoPow(x / 2) % mol;
        if (x % 2 == 0) {
            return (a * a) % mol;
        } else {
            return (2 * ((a * a) % mol)) % mol;
        }
    }

}
