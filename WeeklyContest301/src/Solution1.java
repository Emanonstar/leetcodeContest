import java.util.Arrays;

class Solution1 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int a = amount[0];
        int b = amount[1];
        int c = amount[2];
        int x = Integer.max(0, (b + a) - c);
        if (x % 2 == 0) {
            x = x / 2;
        } else {
            x = x / 2 + 1;
        }
        return c + x;
    }
}
