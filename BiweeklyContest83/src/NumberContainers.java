import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class NumberContainers {
    Map<Integer, Integer> index2Num;
    Map<Integer, Set<Integer>> num2Index;

    public NumberContainers() {
        index2Num = new HashMap<>();
        num2Index = new HashMap<>();
    }

    public void change(int index, int number) {
        if (index2Num.containsKey(index)) {
            int prev = index2Num.get(index);
            num2Index.get(prev).remove(index);
        }
        index2Num.put(index, number);
        if (num2Index.containsKey(number)) {
            num2Index.get(number).add(index);
        } else {
            Set<Integer> pq = new TreeSet<>();
            pq.add(index);
            num2Index.put(number, pq);
        }
    }

    public int find(int number) {
        if (num2Index.containsKey(number)) {
            Set<Integer> pq = num2Index.get(number);
            if (!pq.isEmpty()) {
                return pq.iterator().next();
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}
