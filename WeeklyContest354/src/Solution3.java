import java.util.Arrays;
import java.util.List;

class Solution3 {
    public int minimumIndex(List<Integer> nums) {
        int l = nums.size();
        Integer[] a = nums.toArray(new Integer[0]);
        Arrays.sort(a);
        int de = -1;
        for (int i = 0; i < l / 2; i++) {
            if (a[i + l / 2].equals(a[i])) {
                de = a[i];
                break;
            }
        }
        // System.out.println(de);
        if (de < 0) return -1;
        int[] cnts = new int[l + 1];
        for (int i = 0; i < l; i++) {
            if (nums.get(i) == de) {
                cnts[i + 1] = cnts[i] + 1;
            } else {
                cnts[i + 1] = cnts[i];
            }
        }
        for (int i = 0; i < l - 1; i++) {
            if (cnts[i + 1] * 2 > (i + 1) && (cnts[l] - cnts[i + 1]) * 2 > (l - i - 1)) return i;
        }
        return -1;
    }
}
