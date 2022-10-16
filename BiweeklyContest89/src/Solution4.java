import java.util.*;

class Solution4 {
    Map<Integer, Set<Integer>> neighbors;
    int[] nums;
    boolean[] marked;

    public int componentValue(int[] nums, int[][] edges) {
        this.nums = nums;
        int l = nums.length;
        neighbors = new HashMap<>();
        for (int[] e: edges) {
            int s = e[0], v = e[1];
            if (neighbors.containsKey(s)) {
                neighbors.get(s).add(v);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(v);
                neighbors.put(s, set);
            }

            if (neighbors.containsKey(v)) {
                neighbors.get(v).add(s);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(s);
                neighbors.put(v, set);
            }
        }

        int sum = 0;
        for (int n: nums) {
            sum += n;
        }

        List<Integer> fracs = new ArrayList<>();
        for (int i = 1; i < sum; i++) {
            if (sum % i == 0) {
                fracs.add(i);
            }
        }

        int num = 1;
        for (int i = 0; i < fracs.size(); i++) {
            int f = fracs.get(i);
            marked = new boolean[l];
            int r = DFS(0, f);
            if (r == 0) {
                num = sum / f;
                break;
            }
        }
        return num - 1;
    }

    private int DFS(int s, int value) {
        int sum = nums[s];
        marked[s] = true;
        if (neighbors.containsKey(s)) {
            for (int v: neighbors.get(s)) {
                if (!marked[v]) {
                    int tmp = DFS(v, value);
                    if (tmp < 0) {
                        return -1;
                    } else {
                        sum += tmp;
                    }
                }
            }
        }

        if (sum == value) {
            return 0;
        } else if (sum > value) {
            return -1;
        } else {
            return sum;
        }
    }
}
