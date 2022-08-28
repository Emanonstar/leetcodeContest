class Solution3 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int l = garbage.length;
        int ans = 0;
        int MP = 0, PP = 0, GP = 0;
        for (int i = 0; i < l; i++) {
            String g = garbage[i];
            int M = 0, P = 0, G = 0;
            for (int j = 0; j < g.length(); j++) {
                char c = g.charAt(j);
                if (c == 'M') {
                    M += 1;
                }
                if (c == 'P') {
                    P += 1;
                }
                if (c == 'G') {
                    G += 1;
                }
            }
            if (M != 0) {
                ans += M;
                MP = i;
            }
            if (P != 0) {
                ans += P;
                PP = i;
            }
            if (G != 0) {
                ans += G;
                GP = i;
            }
        }
        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }
        if (MP > 0) {
            ans += travel[MP - 1];
        }

        if (PP > 0) {
            ans += travel[PP - 1];
        }
        if (GP > 0) {
            ans += travel[GP - 1];
        }
        return ans;
    }
}
