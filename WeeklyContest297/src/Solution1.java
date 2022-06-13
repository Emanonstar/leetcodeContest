class Solution1 {
    public double calculateTax(int[][] brackets, int income) {
        double r = 0.0;
        int last = 0;
        for (int[] bracket: brackets) {
            if (income > bracket[0]) {
                r = r + (bracket[0] - last) * bracket[1] / 100.0;
                last = bracket[0];
            } else {
                r = r + (income - last) * bracket[1] / 100.0;
                return r;
            }
        }
        return r + (income - last) * brackets[brackets.length - 1][1] / 100.0;
    }
}
