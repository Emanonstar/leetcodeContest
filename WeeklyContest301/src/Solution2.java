import java.util.PriorityQueue;

class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    int k;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        k = 1;
    }

    public int popSmallest() {
        if (pq.isEmpty()) {
            int rst = k;
            k += 1;
            return rst;
        }
        return pq.poll();
    }

    public void addBack(int num) {
        if (num < k && !pq.contains(num)) {
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
