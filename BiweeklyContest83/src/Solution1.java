import java.util.Arrays;

class Solution1 {
    public String bestHand(int[] ranks, char[] suits) {
        int n = ranks.length;
        char c = suits[0];
        boolean isFlash = true;
        for (int i = 0; i < n; i++) {
            if (suits[i] != c) {
                isFlash = false;
                break;
            }
        }
        if (isFlash) {
            return "Flush";
        }
        Arrays.sort(ranks);
        int max = 1;
        int count = 1;
        int lastRank = ranks[0];
        for (int i = 1; i < n; i++) {
            int r = ranks[i];
            if (r == lastRank) {
                count++;
                max = Integer.max(max, count);
            } else {
                lastRank = r;
                count = 1;
            }
        }
        if (max >= 3) {
            return "Three of a Kind";
        } else if (max == 2) {
            return "Pair";
        } else {
            return "High Card";
        }
    }
}
