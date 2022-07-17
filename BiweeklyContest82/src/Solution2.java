import java.util.Arrays;

class Solution2 {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(passengers);
        Arrays.sort(buses);
        int count = 0;
        int busNum = 0;
        int n = 0;
        for (int i = 0; i < buses.length; i++) {
            busNum = i;
            int bus = buses[i];
            n = 0;
            if (count == passengers.length) {
                break;
            }
            while (n < capacity) {
                if (passengers[count] <= bus) {
                    count += 1;
                    n += 1;
                    if (count == passengers.length) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        int ans;
        if (busNum == buses.length - 1 && n == capacity) {
            ans = passengers[count - 1] - 1;
            int i = count - 2;
            if (i < 0) {
                return ans;
            }
            while (ans == passengers[i]) {
                ans = passengers[i] - 1;
                i -= 1;
                if (i < 0) {
                    return ans;
                }
            }
            return ans;
        } else {
            ans = buses[busNum];
            int i = count - 1;
            if (i < 0) {
                return ans;
            }
            while (ans == passengers[i]) {
                ans = passengers[i] - 1;
                i -= 1;
                if (i < 0) {
                    return ans;
                }
            }
            return ans;
        }
    }
}
