import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums[0].length();
        int l = nums.length;
        Map<Integer, Tuple[]>  map= new HashMap<>();
        for (int i = 1; i <= n; i++) {
            Tuple[] left = new Tuple[l];
            for (int j = 0; j < l; j++) {
                String s = nums[j];
                String ns = s.substring(n - i);
                left[j] = new Tuple(j, ns);
            }
            Arrays.sort(left);
            map.put(i, left);
        }

        int ll = queries.length;
        int[] ans = new int[ll];
        for (int i = 0; i < ll; i++) {
            int[] q = queries[i];
            ans[i] = map.get(q[1])[q[0] - 1].p;
        }
        return ans;
    }

    private static class Tuple implements Comparable<Tuple> {
        int p;
        String v;

        Tuple (int p, String v) {
            this.p = p;
            this.v = v;
        }

        @Override
        public int compareTo(Tuple t) {
            if (!this.v.equals(t.v)) {
                return this.v.compareTo(t.v);
            }
            return this.p - t.p;
        }

    }
}
