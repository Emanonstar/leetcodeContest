import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        List<Integer> oddOfNums = new ArrayList<>();
        List<Integer> evenOfNums = new ArrayList<>();
        List<Integer> oddOfTarget = new ArrayList<>();
        List<Integer> evenOfTarget = new ArrayList<>();
        for (int n: nums) {
            if (n % 2 == 0) {
                evenOfNums.add(n);
            } else {
                oddOfNums.add(n);
            }
        }
        for (int n: target) {
            if (n % 2 == 0) {
                evenOfTarget.add(n);
            } else {
                oddOfTarget.add(n);
            }
        }
        Collections.sort(oddOfNums);
        Collections.sort(oddOfTarget);
        Collections.sort(evenOfTarget);
        Collections.sort(evenOfNums);
        long ans = 0;
        for (int i = 0; i < oddOfNums.size(); i++) {
            ans = ans + Math.abs(oddOfNums.get(i) - oddOfTarget.get(i)) / 2;
        }
        for (int i = 0; i < evenOfNums.size(); i++) {
            ans = ans + Math.abs(evenOfNums.get(i) - evenOfTarget.get(i)) / 2;
        }
        return ans / 2;
    }
}
