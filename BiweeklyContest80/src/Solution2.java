import java.util.Arrays;

class Solution2 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            result[i] = 0;
            int l = 0;
            int r = potions.length;
            int pos = 0;
            while (l < r) {
                pos = (l + r) / 2;
                long m = (long)spells[i] * potions[pos];
                if (m < success) {
                    l = pos + 1;
                } else {
                    r = pos;
                }
            }
            result[i] = potions.length - l;
        }
        return result;
    }
}
