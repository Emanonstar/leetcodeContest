import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution4 {
    public long minimumMoney(int[][] transactions) {
        int l = transactions.length;
        List<Transaction> l1 = new ArrayList<>();
        List<Transaction> l2 = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            Transaction t = new Transaction(transactions[i][0], transactions[i][1]);
            if (t.cost < t.cashback) {
                l2.add(t);
            } else {
                l1.add(t);
            }
        }
        l1.sort(Comparator.naturalOrder());
        long ans = 0;
        for (Transaction t: l2) {
            if (t.cost > ans) {
                ans = t.cost;
            }
        }

        for (Transaction t: l1) {
            ans = Long.max(ans - t.cashback + t.cost, t.cost);
        }
        return ans;
    }

    static class Transaction implements Comparable<Transaction>{
        int cost;
        int cashback;

        Transaction(int cost, int cashback) {
            this.cost = cost;
            this.cashback = cashback;
        }

        @Override
        public int compareTo(Transaction t) {
            if (cashback == t.cashback) {
                return cost - t.cost;
            }
            return t.cashback - cashback;
        }
    }
}

