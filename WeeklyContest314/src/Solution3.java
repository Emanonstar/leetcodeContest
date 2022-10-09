import java.util.ArrayDeque;
import java.util.Deque;

class Solution3 {
    public String robotWithString(String s) {
        int l = s.length();
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer();

        char[] leastFrom = new char[l];
        leastFrom[l - 1] = s.charAt(l - 1);
        for (int i = l - 2; i >= 0; i--) {
            char c = s.charAt(i);
            if(c - leastFrom[i + 1] < 0) {
                leastFrom[i] = c;
            } else {
                leastFrom[i] = leastFrom[i + 1];
            }
        }
        for (int i = 0; i < l; i++) {
            while (!dq.isEmpty() && s.charAt(dq.peekLast()) <= leastFrom[i]) {
                sb.append(s.charAt(dq.pollLast()));
            }
            dq.addLast(i);
        }

        while (!dq.isEmpty()) {
            sb.append(s.charAt(dq.pollLast()));
        }
        return sb.toString();
    }
}
