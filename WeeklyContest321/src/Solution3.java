import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution3 {
    public ListNode removeNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode p = head; p != null; p = p.next) {
            list.add(p.val);
        }
        int l = list.size();
        int max = -1;
        int[] maxAtRight = new int[l];
        for (int i = l - 1; i >= 0; i--) {
            maxAtRight[i] = max;
            max = Integer.max(max, list.get(i));
        }

        ListNode ans = new ListNode();
        ListNode p = ans;
        for (int i = 0; i < l; i++) {
            if (list.get(i) >= maxAtRight[i]) {
                ListNode node = new ListNode(list.get(i));
                if (p == null) {
                    ans = node;
                    p = node;
                } else {
                    p.next = node;
                    p = node;
                }
            }
        }
        return ans.next;
    }
}
