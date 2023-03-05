class Solution1 {
    public int passThePillow(int n, int time) {
        int ans = 1;
        boolean drt = true;
        for (int i = 0; i < time; i++) {
            if (drt) {
                if (ans < n) {
                    ans += 1;
                } else {
                    drt = !drt;
                    ans -= 1;
                }
            } else {
                if (ans > 1) {
                    ans -= 1;
                } else {
                    drt = !drt;
                    ans += 1;
                }
            }
        }
        return ans;
    }
}
