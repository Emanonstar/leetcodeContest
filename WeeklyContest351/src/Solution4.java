import java.util.*;

class Solution4 {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int l = positions.length;
        Robot[] robots = new Robot[l];
        for (int i = 0; i < l; i++) {
            robots[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));
        }
        Arrays.sort(robots, (r1, r2) -> r1.pos - r2.pos);
        Stack<Robot> surviveMoveRight = new Stack<>();
        List<Robot> surviveRobots = new ArrayList<>();
        for (Robot robot: robots) {
            if (robot.drt == 'R') {
                surviveMoveRight.push(robot);
            } else {
                while (!surviveMoveRight.isEmpty() && robot.hlh > 0) {
                    Robot next = surviveMoveRight.peek();
                    if (next.hlh > robot.hlh) {
                        next.hlh -= 1;
                        robot.hlh = 0;
                    } else if (next.hlh < robot.hlh) {
                        surviveMoveRight.pop();
                        robot.hlh -= 1;
                    } else {
                        surviveMoveRight.pop();
                        robot.hlh = 0;
                    }
                }
                if (robot.hlh > 0) surviveRobots.add(robot);
            }
        }
        while (!surviveMoveRight.isEmpty()) {
            surviveRobots.add(surviveMoveRight.pop());
        }
        surviveRobots.sort((r1, r2) -> r1.index - r2.index);
        List<Integer> ans = new ArrayList<>();
        for (Robot robot: surviveRobots) ans.add(robot.hlh);
        return ans;
    }

    private class Robot {
        int index;
        int pos;
        int hlh;
        char drt;

        public Robot (int i, int p, int h, char d) {
            index = i;
            pos= p;
            hlh = h;
            drt = d;
        }
    }
}
