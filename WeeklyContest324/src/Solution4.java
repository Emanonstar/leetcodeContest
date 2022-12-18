import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution4 {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int l = queries.length;
        int[] ans = new int[l];
        for (int i = 0; i < l; i++) {
            int[] query = queries[i];
            List<Integer> list1 = path(query[0]);
            List<Integer> list2 = path(query[1]);
            int j;
            for (j = 0; j < Integer.min(list1.size(), list2.size()); j++) {
                if (!list1.get(j).equals(list2.get(j))) {
                    break;
                }
            }
            ans[i] = list1.size() + list2.size() - 2 * j + 1;
        }
        return ans;
    }

    private List<Integer> path(int query) {
        List<Integer> list = new ArrayList<>();
        while (query != 0) {
            list.add(query);
            query = query / 2;
        }
        Collections.reverse(list);
        return list;
    }
}
