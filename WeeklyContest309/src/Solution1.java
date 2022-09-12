class Solution1 {
    public boolean checkDistances(String s, int[] distance) {
        int l = s.length();
        int[] dis = new int[26];
        boolean[] flag = new boolean[26];
        for (int i = 0; i < l; i++) {
            int c = s.charAt(i) - 'a';
            if (flag[c]) {
                dis[c] = i - dis[c] - 1;
            } else {
                dis[c] = i;
                flag[c] = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (flag[i]) {
                if (dis[i] != distance[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
