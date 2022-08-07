import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ret = new ArrayList<>();
        int[] a = new int[1001];
        for (int[] item: items1) {
            a[item[0]] += item[1];
        }
        for (int[] item: items2) {
            a[item[0]] += item[1];
        }

        for (int i = 1; i < 1001; i++) {
            if (a[i] > 0) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                l.add(a[i]);
                ret.add(l);
            }
        }
        return ret;
    }
}
