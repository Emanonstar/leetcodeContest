import java.util.Arrays;
import java.util.PriorityQueue;

class Solution4 {
    public int mostBooked(int n, int[][] meetings) {
        int[] ans = new int[n];
        PriorityQueue<Room> freeRooms = new PriorityQueue<>();
        Room[] rooms = new Room[n];
        for (int i = 0; i < n; i++) {
            Room r = new Room(i, 0, true);
            freeRooms.add(r);
            rooms[i] = r;
        }
        PriorityQueue<Meeting> Meetings = new PriorityQueue<>();

        for (int[] m: meetings) {
            Meetings.add(new Meeting(m[0], m[1]));
        }

        while (Meetings.size() != 0) {
            Meeting m = Meetings.poll();
            for (Room r : rooms) {
                if (!r.isFree && r.availbleTime <= m.start) {
                    r.isFree = true;
                    freeRooms.add(r);
                }
            }
            Room r = rooms[0];
            if (freeRooms.size() == 0) {
                long time = Long.MAX_VALUE;
                for (Room room: rooms) {
                    if (room.availbleTime < time) {
                        time = room.availbleTime;
                        r = room;
                    }
                }
            } else {
                r = freeRooms.poll();
            }
            if (r.availbleTime < m.start) {
                r.availbleTime = m.end;
            } else {
                r.availbleTime += m.duration;
            }
            r.isFree = false;
            ans[r.index] += 1;
        }
        int rst = -1;
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (ans[i] > max) {
                rst = i;
                max = ans[i];
            }
        }
        return rst;
    }

    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;
        int duration;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
            duration = end - start;
        }

        @Override
        public int compareTo(Meeting m) {
            return this.start - m.start;
        }
    }

    static class Room implements Comparable<Room>{
        int index;
        long availbleTime;
        boolean isFree;

        Room(int index, long availbleTime, boolean b) {
            this.availbleTime = availbleTime;
            this.index = index;
            isFree = b;
        }

        @Override
        public int compareTo(Room r) {
            return this.index - r.index;
        }
    }
}
