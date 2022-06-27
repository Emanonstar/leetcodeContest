class Solution3 {
    public int maximumXOR(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result = result | n;
        }
        return result;
    }
}
