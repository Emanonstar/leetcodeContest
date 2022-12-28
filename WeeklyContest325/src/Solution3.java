import java.util.Arrays;

class Solution3 {
    public int maximumTastiness(int[] price, int k) {
        int l = price.length;
        Arrays.sort(price);
        int left = 0, right = price[l - 1] - price[0];
        while (left < right) {
            int mid = (left + right) / 2;
            if (isFit(price, mid, k)) {
                left = mid  + 1;
            } else {
                right = mid - 1;
            }
        }
        if (isFit(price, left  + 1, k)) {
            return left;
        } else if (isFit(price, left, k)){
            return left;
        } else {
            return left - 1;
        }
    }

    private boolean isFit(int[] price, int diff, int k) {
        int cnt = 0;
        int target = 0;
        for (int i = 0; i < price.length; i++) {
            if (price[i] >= target) {
                cnt += 1;
                target = price[i] + diff;
            }
        }
        return cnt >= k;
    }
}
