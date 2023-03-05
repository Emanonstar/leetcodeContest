import java.util.*;

class Solution3 {
    public int findValidSplit(int[] nums) {
        int l = nums.length;
        Map<Integer, Integer> primeRightest = new HashMap<>();
        Set<Integer>[] primeFacts = new Set[l];
        Set<Integer> indexTodelte = new HashSet<>();
        for (int i = 0; i < l; i++) {
            primeFacts[i] = findPrimeFacts(nums[i]);
            for (int p: primeFacts[i]) primeRightest.put(p, i);
        }
        for (int i = 0; i < l - 1; i++) {
            for (int p: primeFacts[i]) indexTodelte.add(primeRightest.get(p));
            indexTodelte.remove(i);
            if (indexTodelte.isEmpty()) return i;
        }
        return -1;
    }

    private Set<Integer> findPrimeFacts(int n) {
        int tmp = n;
        Set<Integer> primeFacts = new HashSet<>();
        for (int j = 2; j * j <= tmp; j++) {
            while (tmp % j == 0) {
                primeFacts.add(j);
                tmp /= j;
            }
        }
        if (tmp > 1) primeFacts.add(tmp);
        return primeFacts;
    }
//    public int findValidSplit(int[] nums) {
//        int l = nums.length;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int n : nums) {
//            int tmp = n;
//            for (int j = 2; j * j <= tmp; j++) {
//                while (tmp % j == 0) {
//                    mapAdd(map, j);
//                    tmp /= j;
//                }
//            }
//            if (tmp > 1) mapAdd(map, tmp);
//        }
//
//        Map<Integer, Integer> left = new HashMap<>();
//        for (int i = 0; i < l - 1; i++) {
//            int tmp = nums[i];
//            for (int j = 2; j * j <= tmp; j++) {
//                while (tmp % j == 0) {
//                    mapAdd(left, j);
//                    mapRemove(map, j);
//                    tmp /= j;
//                }
//            }
//            if (tmp > 1) {
//                mapAdd(left, tmp);
//                mapRemove(map, tmp);
//            }
//            boolean flag = true;
//            for (int p: left.keySet()) {
//                if (map.containsKey(p)) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) return i;
//
//        }
//        return -1;
//    }
//
//    private int mapAdd(Map<Integer, Integer> map, Integer key) {
//        int v = map.getOrDefault(key, 0) + 1;
//        map.put(key, v);
//        return v;
//    }
//
//    private boolean mapRemove(Map<Integer, Integer> map, Integer key) {
//        int v = map.getOrDefault(key, 1) - 1;
//        map.put(key, v);
//        if (v == 0) {
//            map.remove(key);
//            return true;
//        }
//        return false;
//    }
}
