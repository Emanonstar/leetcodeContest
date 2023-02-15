import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int l = s.length();
        int[] vals = new int[l];
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < l; i++) {
            vals[i] = (i == 0 ? s.charAt(i) - '0' : 2 * vals[i - 1] +  s.charAt(i) - '0');
            int[] v = new int[2];
            v[1] = i;
            map.put(vals[i], v);
        }

        int one = s.indexOf('1');
        int zero = s.indexOf('0');
        int[] ones = new int[2];
        Arrays.fill(ones, one);
        int[] zeros = new int[2];
        Arrays.fill(zeros, zero);
        map.put(1, ones);
        map.put(0, zeros);
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l && j < i + 32; j++) {
                int key = vals[j] - (vals[i] << (j - i));
                int[] v = new int[2];
                v[0] = i + 1;
                v[1] = j;
                if (!map.containsKey(key)) {
                    map.put(key, v);
                } else {
                    int ll = map.get(key)[1] - map.get(key)[0] + 1;
                    if (ll > j - i) {
                        map.put(key, v);
                    }
                    if (j - i == ll && i + 1 < map.get(key)[0]) {
                        map.put(key, v);
                    }
                }
            }
        }
        int[][] ans = new int[queries.length][2];
        int[] def = new int[2];
        Arrays.fill(def, -1);
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0] ^ queries[i][1];
            ans[i] = map.getOrDefault(k, def);
        }
        return ans;
    }
}
