class Solution1 {
    public boolean isCircularSentence(String sentence) {
        int l = sentence.length();

        for (int i = 0; i < l; i++) {
            if (sentence.charAt(i) == ' ') {
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return sentence.charAt(l - 1) == sentence.charAt(0);
    }
}
