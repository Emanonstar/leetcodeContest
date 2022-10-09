class Solution2 {
    public int[] findArray(int[] pref) {
        int l = pref.length;
        int[] a = new int[l];
        a[0] = pref[0];
        for (int i = 1; i < l; i++) {
            a[i] = pref[i - 1] ^ pref[i];
        }
        return a;
    }
}
