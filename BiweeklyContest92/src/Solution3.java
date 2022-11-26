class Solution3 {
    public int bestClosingTime(String customers) {
        int l = customers.length();
        int[] p1 = new int[l + 1];
        int[] p2 = new int[l + 1];

        for (int i = 0; i < l; i++) {
            if (customers.charAt(i) == 'N') {
                p1[i + 1] = 1;
            } else {
                p2[i] = 1;
            }
        }

        for (int i = 1; i <= l; i++) {
            p1[i] += p1[i - 1];
        }

        for (int i = l - 1; i >= 0; i--) {
            p2[i] += p2[i + 1];
            p1[i] += p2[i];
        }

        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i <= l; i++) {
            System.out.println(p1[i]);
            if (p1[i] < min) {
                min = p1[i];
                ans = i;
            }
        }
        return ans;
    }
}
