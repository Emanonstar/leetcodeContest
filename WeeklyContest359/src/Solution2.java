import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public int minimumSum(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int cnt = 0, sum = 0, num = 1;
        while (cnt < n) {
            while (!set.isEmpty() && set.contains((k - num))) {
                num += 1;
            }
            set.add(num);
            sum += num;
            cnt += 1;
            num += 1;
        }
        return sum;
    }
}
