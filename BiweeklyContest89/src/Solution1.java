class Solution1 {
    public int countTime(String time) {
        int ans = 0;
        int[] a = new int[5];
        for (int i = 0; i < 5; i++) {
            if (time.charAt(i) == '?') {
                a[i] = 1;
            }
        }
        if (a[0] == 1 && a[1] == 1) {
            ans = 24;
        } else if (a[0] == 1) {
            for (int i = 0; i < 10; i++) {
                int h = i * 10 + time.charAt(1) - '0';
                if (h >= 0 && h <= 23) {
                    ans += 1;
                }
            }
        } else if (a[1] == 1) {
            for (int i = 0; i < 10; i++) {
                int h = i + (time.charAt(0) - '0') * 10;
                if (h >= 0 && h <= 23) {
                    ans += 1;
                }
            }
        } else {
            ans = 1;
        }

        int b = 0;
        if (a[3] == 1 && a[4] == 1) {
            b = 60;
        } else if (a[3] == 1) {
            for (int i = 0; i < 10; i++) {
                int h = i * 10 + time.charAt(4) - '0';
                if (h >= 0 && h <= 59) {
                    b += 1;
                }
            }
        } else if (a[4] == 1) {
            for (int i = 0; i < 10; i++) {
                int h = i + (time.charAt(3) - '0') * 10;
                if (h >= 0 && h <= 59) {
                    b += 1;
                }
            }
        } else {
            b = 1;
        }
        return ans * b;
    }
}
