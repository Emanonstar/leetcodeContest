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
class Solution2 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] rst = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rst[i][j] = -1;
            }
        }
        int r = 0, c = 0;
        int drt = 0;
        for (int i = 0;  i < m * n; i++) {
            if (head == null) {
                break;
            }
            if (rst[r][c] != -1) {
                break;
            }
            rst[r][c] = head.val;
            head = head.next;
            switch (drt) {
                case 0:
                    if (c == n - 1 || rst[r][c + 1] != -1) {
                        r += 1;
                        drt = 1;
                    } else {
                        c += 1;
                    }
                    break;
                case 1:
                    if (r == m - 1 || rst[r + 1][c] != -1) {
                        c -= 1;
                        drt = 2;
                    } else {
                        r += 1;
                    }
                    break;
                case 2:
                    if (c == 0 || rst[r][c - 1] != -1) {
                        r -= 1;
                        drt = 3;
                    } else {
                        c -= 1;
                    }
                    break;
                default:
                    if (r == 0 || rst[r - 1][c] != -1) {
                        c += 1;
                        drt = 0;
                    } else {
                        r -= 1;
                    }
            }
        }
        return rst;
    }

     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
