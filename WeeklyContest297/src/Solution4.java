import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution4 {
    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> first2last = new HashMap<>();

        for (String idea : ideas) {
            char f = idea.charAt(0);
            String l = idea.substring(1);
            if (!first2last.containsKey(f)) {
                first2last.put(f, new HashSet<>());
            }
            first2last.get(f).add(l);
        }
        long count = 0;
        for (char c1 : first2last.keySet()) {
            for (char c2 : first2last.keySet()) {
                if (c1 == c2) {
                    continue;
                }
                Set<String> s1 = first2last.get(c1);
                Set<String> s2 = first2last.get(c2);
                long n1 = s1.size();
                long n2 = s2.size();
                for (String s : s1) {
                    if (s2.contains(s)) {
                        n1 -= 1;
                        n2 -= 1;
                    }
                }
               count += n1 * n2;
            }
        }
        return count;
    }
}
