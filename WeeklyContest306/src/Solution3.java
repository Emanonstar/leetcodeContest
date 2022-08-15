import java.util.Set;
import java.util.TreeSet;

class Solution3 {
    String ans = "999999999";
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        Set<Character> set = new TreeSet<>();
        for (int i = 0; i < 9; i++) {
            set.add((char) ('1' + i));
        }

        for (int i = 0; i < 9; i++) {
            char c = (char) ('1' + i);
            Set<Character> nset = new TreeSet<>(set);
            nset.remove(c);
            helper(pattern, ""+ c, nset);
        }
        return ans;
    }

    private void helper(String pattern, String current, Set<Character> set) {
        if (pattern.equals("")) {
            if (current.compareTo(ans) < 0) {
                ans = current;
            }
            return;
        }

        char c = pattern.charAt(0);
        String left = pattern.substring(1);
        char last = current.charAt(current.length() - 1);
        if (c == 'I') {
            for (char cc: set) {
                if (cc > last) {
                    Set<Character> nset = new TreeSet<>(set);
                    nset.remove(cc);
                    helper(left, current + cc, nset);
                }
            }
        } else {
            for (char cc: set) {
                if (cc < last) {
                    Set<Character> nset = new TreeSet<>(set);
                    nset.remove(cc);
                    helper(left, current + cc, nset);
                }
            }
        }
    }

}
