import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i < n - 1; i++) {
            if (!helper(n, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean helper(int n, int base) {
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            int digit = n % base;
            n = n / base;
            list.add(digit);
        }

        int l = list.size();
        for (int i = 0; i < l / 2; i++) {
            if (!list.get(i).equals(list.get(l - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
