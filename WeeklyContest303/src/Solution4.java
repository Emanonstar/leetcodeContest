import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution4 {
    int[] bits;
    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int n = set.size();
        bits = new int[n];
        int i = 0;
        for (int num: set) {
            bits[i] = Integer.bitCount(num);
            i++;
        }

        long ans = 0;
        Arrays.sort(bits);
        for (int bit : bits) {
            ans += numOfLargerThan(k - bit);
        }
        return ans;
    }

//    private int bitsOf(int num) {
//        int rst = 0;
//        int mask = 1;
//        for (int i = 0; i < 32; i++) {
//            if ((num & mask) != 0) {
//                rst += 1;
//            }
//            mask = mask << 1;
//        }
//        return rst;
//    }

    private int numOfLargerThan(int key) {
        int n = bits.length;
        int l = 0, r = n;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;

            if (key <= bits[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (l < n && bits[l] < key) {
            l++;
        }
        return n - l;
    }
}
