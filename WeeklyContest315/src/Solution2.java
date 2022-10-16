import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
            String s = String.valueOf(n);
            String ns = "";
            for (int i = s.length() - 1; i >= 0; i--) {
                ns += s.charAt(i);
            }
            set.add(Integer.valueOf(ns));
        }
        return set.size();
    }
}
