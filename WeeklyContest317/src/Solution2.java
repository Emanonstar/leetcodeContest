import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int l = creators.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            String c = creators[i];
            int v = views[i];
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + v);
            } else {
                map.put(c, v);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        Map<String, List<Integer>> map1 = new HashMap<>();
        int max = 0;
        for (String s: map.keySet()) {
            max = Integer.max(max, map.get(s));
        }
        for (int i = 0; i < l; i++) {
            String s = creators[i];
            if (map.get(s) == max) {
                if (map1.containsKey(s)) {
                    map1.get(s).add(i);
                } else {
                    List<Integer> ll = new ArrayList<>();
                    ll.add(i);
                    map1.put(s, ll);
                }
            }
        }
        
        for (String s: map1.keySet()) {
            List<String> list1 = new ArrayList<>();
            list1.add(s);
            int max1 = -1;
            String id = "";
            for (int i: map1.get(s)) {
                if (views[i] > max1) {
                    max1 = views[i];
                    id = ids[i];
                } else if (views[i] == max1) {
                    if (ids[i].compareTo(id) < 0) {
                        id = ids[i];
                    }
                }
            }
            list1.add(id);
            ans.add(list1);
        }
        return ans;
    }
}
