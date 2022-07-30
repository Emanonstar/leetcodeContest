class Solution4 {
    public int shortestSequence(int[] rolls, int k) {
        boolean[] hasRoll = new boolean[k];
        int ans = 1;
        int count = 0;
        for (int r : rolls) {
            if (!hasRoll[r - 1]) {
                hasRoll[r - 1] = true;
                count++;
            }
            if (count == k) {
                hasRoll = new boolean[k];
                count = 0;
                ans++;
            }
        }
        return ans;
    }
}
