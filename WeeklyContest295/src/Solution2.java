public class Solution2 {
    public String discountPrices(String sentence, int discount) {
        String rst = "";
        String[] words = sentence.split(" ");
        for (String word: words) {
            if (word.startsWith("$")) {
                String price = word.substring(1);
                try {
                    double p = Double.parseDouble(price);
                    p = p * (100 - discount) / 100;
                    rst = rst + '$' + String.format("%.2f", p) + ' ';
                } catch (Exception e) {
                    rst = rst + word + ' ';
                }
            } else {
                rst = rst + word + ' ';
            }
        }
        return rst.substring(0, rst.length() - 1);
    }
}
