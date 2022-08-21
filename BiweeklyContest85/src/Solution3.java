class Solution3 {
    public String shiftingLetters(String s, int[][] shifts) {
        int l = s.length();
        char[] array = s.toCharArray();
        int[] finalShifts = new int[l + 1];

        for (int[] shift: shifts) {
            int begin = shift[0];
            int end = shift[1];
            int drt = shift[2];
            if (drt == 0) {
                finalShifts[begin] -= 1;
                finalShifts[end + 1] += 1;
            } else {
                finalShifts[begin] += 1;
                finalShifts[end + 1] -= 1;
            }
        }

        for (int i = 1; i < l; i++) {
            finalShifts[i] += finalShifts[i - 1];
        }

        for (int i = 0; i < l; i++) {
            array[i] = shifting(array[i], finalShifts[i] % 26);
        }

        return String.valueOf(array);
    }

    private char shifting(char c, int k) {
        if (k == 0) {
            return c;
        }
        if (k > 0) {
            return shifting(forward(c), k - 1);
        } else {
            return shifting(backward(c), k + 1);
        }
    }
    private char forward(char c) {
        if (c == 'z') {
            return 'a';
        }
        return (char) (c + 1);
    }

    private char backward(char c) {
        if (c == 'a') {
            return 'z';
        }
        return (char) (c - 1);
    }
}
