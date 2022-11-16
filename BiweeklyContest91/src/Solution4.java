class Solution4 {
    public String[] splitMessage(String message, int limit) {
        int l = message.length();
        int part = 0;
        if (limit > 5 && l <= 9 * (limit - 5)) {
            part = l / (limit - 5);
            if (l % (limit - 5) != 0) {
                part += 1;
            }
        } else if (limit > 7 && l <= 9 * (limit - 6) + 90 * (limit - 7)) {
            part = (l - 9 * (limit - 6)) / (limit - 7) + 9;
            if ((l - 9 * (limit - 6)) % (limit - 7) != 0) {
                part += 1;
            }
        } else if (limit > 9 && l <=  9 * (limit - 7) + 90 * (limit - 8) + 900 * (limit - 9)) {
            part = (l - 9 * (limit - 7) - 90 * (limit - 8)) / (limit - 9) + 99;
            if ((l - 9 * (limit - 7) - 90 * (limit - 8)) % (limit - 9) != 0) {
                part += 1;
            }
        } else if (limit > 11 && l <=  9 * (limit - 8) + 90 * (limit - 9) + 900 * (limit - 10) + 9000 * (limit - 11)) {
            part = (l - 9 * (limit - 8) - 90 * (limit - 9) - 900 * (limit - 10)) / (limit - 11) + 999;
            if ((l - 9 * (limit - 8) - 90 * (limit - 9) - 900 * (limit - 10)) % (limit - 11) != 0) {
                part += 1;
            }
        }

        if (part == 0) {
            return new String[] {};
        }

        String[] ans = new String[part];
        if (part < 10) {
            int index = 0;
            for (int i = 0; i < part - 1; i++) {
                String s = message.substring(index, index + (limit - 5)) + "<" + (i + 1) + "/" + part + ">";
                index += (limit - 5);
                ans[i] = s;
            }
            ans[part - 1] = message.substring(index) + "<" + part + "/" + part + ">";
        } else if (part < 100) {
            int index = 0;
            for (int i = 0; i < 9; i++) {
                String s = message.substring(index, index + (limit - 6)) + "<" + (i + 1) + "/" + part + ">";
                index += (limit - 6);
                ans[i] = s;
            }
            for (int i = 9; i < part - 1; i++) {
                String s = message.substring(index, index + (limit - 7)) + "<" + (i + 1) + "/" + part + ">";
                index += (limit - 7);
                ans[i] = s;
            }
            ans[part - 1] = message.substring(index) + "<" + part + "/" + part + ">";
        } else if (part < 1000) {
            int index = 0;
            for (int i = 0; i < 9; i++) {
                String s = message.substring(index, index + (limit - 7)) + "<" + (i + 1) + "/" + part + ">";
                index += (limit - 7);
                ans[i] = s;
            }
            for (int i = 9; i < 99; i++) {
                String s = message.substring(index, index + (limit - 8)) + "<" + (i + 1) + "/" + part + ">";
                index += (limit - 8);
                ans[i] = s;
            }
            for (int i = 99; i < part - 1; i++) {
                String s = message.substring(index, index + (limit - 9)) + "<" + (i + 1) + "/" + part + ">";
                index += (limit - 9);
                ans[i] = s;
            }
            ans[part - 1] = message.substring(index) + "<" + part + "/" + part + ">";
        } else {
            int index = 0;
            for (int i = 0; i < 9; i++) {
                String s = message.substring(index, index + (limit - 8)) + "<" + (i + 1) + "/" + part + ">";
                index += (limit - 8);
                ans[i] = s;
            }
            for (int i = 9; i < 99; i++) {
                String s = message.substring(index, index + (limit - 9)) + "<" + (i + 1) + "/" + part + ">";
                index += (limit - 9);
                ans[i] = s;
            }
            for (int i = 99; i < 999; i++) {
                String s = message.substring(index, index + (limit - 10)) + "<" + (i + 1) + "/" + part + ">";
                index += (limit - 10);
                ans[i] = s;
            }
            for (int i = 999; i < part - 1; i++) {
                String s = message.substring(index, index + (limit - 11)) + "<" + (i + 1) + "/" + part + ">";
                index += (limit - 11);
                ans[i] = s;
            }
            ans[part - 1] = message.substring(index) + "<" + part + "/" + part + ">";
        }
        return ans;
    }
}
