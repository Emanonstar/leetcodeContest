import java.util.PriorityQueue;

class Solution4 {
    public int findCrossingTime(int n, int k, int[][] time) {
        PriorityQueue<Worker> waitingInLeft = new PriorityQueue<>();
        PriorityQueue<Worker> waitingInRight = new PriorityQueue<>();
        PriorityQueue<int[]> pickingOld = new PriorityQueue<>((x, y)-> x[0] - y[0]);
        PriorityQueue<int[]> puttingNew = new PriorityQueue<>((x, y)-> x[0] - y[0]);

        for (int i = 0; i < k; i++) {
            waitingInLeft.add(new Worker(time[i], i));
        }
        int t = 0;
        boolean free = true;
        boolean direction = true;                  //leftToRight is true
        Worker inBridge = null;
        int timeToFree = -1;
        int cnt = 0;
        int left = n;
        int ans = 0;
        while (true) {
            if (free) {
                if (!waitingInRight.isEmpty()) {
                    inBridge = waitingInRight.poll();
                    free = false;
                    direction = false;
                    timeToFree = t + inBridge.rightToLeft;
                } else if (!waitingInLeft.isEmpty() && left > 0){
                    inBridge = waitingInLeft.poll();
                    free = false;
                    direction = true;
                    timeToFree = t + inBridge.leftToRight;
                    left -= 1;
                }
            }
            t++;
            if (t == timeToFree) {
                int[] a = new int[2];
                if (direction) {
                    a[0] = t + inBridge.pickOld;
                    a[1] = inBridge.index;
                    pickingOld.add(a);
//                    System.out.println("From " + (t - inBridge.leftToRight) + " to " +
//                            t + " worker " + inBridge.index + " cross bridge from left to right");
                } else {
                    a[0] = t + inBridge.putNew;
                    a[1] = inBridge.index;
                    puttingNew.add(a);
//                    System.out.println("From " + (t - inBridge.rightToLeft) + " to " +
//                            t + " worker " + inBridge.index + " cross bridge from right to left");
                }
                free = true;
            }

            while (!pickingOld.isEmpty() && pickingOld.peek()[0] == t) {
                int i = pickingOld.poll()[1];
                waitingInRight.add(new Worker(time[i], i));
//                System.out.println("From " + (t - time[i][1]) + " to " +
//                        t + " worker " + i + " picks a box in old warehouse");

            }
            while (!puttingNew.isEmpty() && puttingNew.peek()[0] == t) {
                int i = puttingNew.poll()[1];
                waitingInLeft.add(new Worker(time[i], i));
//                System.out.println("From " + (t - time[i][3]) + " to " +
//                        t + " worker " + i + " puts a box in new warehouse");
                cnt += 1;
                ans = Integer.max(ans, t - time[i][3]);
                if (cnt == n) {
                    return ans;
                }
            }
        }
    }


    static class Worker implements Comparable<Worker>{
        int leftToRight;
        int pickOld;
        int rightToLeft;
        int putNew;
        int index;

        Worker(int[] worker, int i) {
            leftToRight = worker[0];
            pickOld = worker[1];
            rightToLeft = worker[2];
            putNew = worker[3];
            index = i;
        }

        @Override
        public int compareTo(Worker w) {
            int c = w.leftToRight + w.rightToLeft - leftToRight - rightToLeft;
            if (c == 0) {
                return w.index - index;
            }
            return c;
        }
    }
}
