import java.util.HashSet;
import java.util.Set;

class Solution3 {
    public int minImpossibleOR(int[] nums) {
        int[] ones = new int[32];

        for (int num: nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 32; i++) {
                if (num % 2 == 1) {
                    set.add(i);
                }
                num = num / 2;
            }
            if (set.size() == 1) {
                for (int n: set) {
                    ones[n] += 1;
                }
            }
        }
        int index;
        for (index = 0; index < 32; index++) {
            if (ones[index] == 0) {
                break;
            }
        }
        return (int)Math.pow(2, index);
    }
}
