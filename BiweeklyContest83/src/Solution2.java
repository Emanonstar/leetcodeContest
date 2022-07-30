import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public long zeroFilledSubarray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int last = 0;
        int count = 0;
        for (int n : nums) {
            if (n == 0) {
                count++;
            } else {
                if (last == 0 && count != 0) {
                    list.add(count);
                    count = 0;
                }
            }
            last = n;
        }
        if (count != 0) {
            list.add(count);
        }
        long rst = 0;
        for (int n : list) {
            rst += ((long) n * (n + 1)) / 2;
        }
        return rst;
    }
}
