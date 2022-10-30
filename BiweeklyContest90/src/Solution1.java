class Solution1 {
    public String oddString(String[] words) {
        int l = words.length;
        int n = words[0].length();
        int[][] diffs = new int[2][n - 1];
        int[] cnt = new int[2];

        for (int i = 0; i < l; i++) {
            String word = words[i];
            int[] array = new int[n - 1];
            for (int j = 0; j < n - 1; j++) {
                array[j] = word.charAt(j + 1) - word.charAt(j);
            }
            if (i == 0) {
                diffs[0] = array;
                cnt[0] = 1;
            } else {
                boolean flag = false;
                for (int j = 0; j < n - 1; j++) {
                    if (diffs[0][j] != array[j]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    diffs[1] = array;
                    cnt[1] += 1;
                } else {
                    cnt[0] += 1;
                }
            }
        }

        int[] a;
        if (cnt[0] == 1) {
            a = diffs[1];
        } else {
            a = diffs[0];
        }
        for (int i = 0; i < l; i++) {
            String word = words[i];
            for (int j = 0; j < n - 1; j++) {
                if (a[j] != word.charAt(j + 1) - word.charAt(j)) {
                    return word;
                }
            }
        }
        return "";
    }
}
