class Solution1 {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int maAlice = Integer.parseInt(arriveAlice.substring(0, 2));
        int daAlice = Integer.parseInt(arriveAlice.substring(3));
        int mlAlice = Integer.parseInt(leaveAlice.substring(0, 2));
        int dlAlice = Integer.parseInt(leaveAlice.substring(3));
        int maBob = Integer.parseInt(arriveBob.substring(0, 2));
        int daBob = Integer.parseInt(arriveBob.substring(3));
        int mlBob = Integer.parseInt(leaveBob.substring(0, 2));
        int dlBob = Integer.parseInt(leaveBob.substring(3));
        int[][] m = new int[13][32];
        if (maAlice == mlAlice) {
            for (int j = daAlice; j <= dlAlice; j++) {
                m[maAlice][j] += 1;
            }
        } else {
            for (int j = daAlice; j <= daysOfMonth[maAlice]; j++) {
                m[maAlice][j] += 1;
            }
            for (int i = maAlice + 1; i < mlAlice; i++) {
                for (int j = 1; j <= daysOfMonth[i]; j++) {
                    m[i][j] += 1;
                }
            }
            for (int j = 1; j <= dlAlice; j++) {
                m[mlAlice][j] += 1;
            }
        }

        if (maBob == mlBob) {
            for (int j = daBob; j <= dlBob; j++) {
                m[maBob][j] += 1;
            }
        } else {
            for (int j = daBob; j <= daysOfMonth[maBob]; j++) {
                m[maBob][j] += 1;
            }
            for (int i = maBob + 1; i < mlBob; i++) {
                for (int j = 1; j <= daysOfMonth[i]; j++) {
                    m[i][j] += 1;
                }
            }
            for (int j = 1; j <= dlBob; j++) {
                m[mlBob][j] += 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 32; j++) {
                if (m[i][j] == 2) {
                    ans += 1;
                }
            }
        }
        return ans;
    }
}
