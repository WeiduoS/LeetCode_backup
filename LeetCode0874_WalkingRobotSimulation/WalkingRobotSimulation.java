package LeetCode0874_WalkingRobotSimulation;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
	int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for(int[] ob : obstacles) {
            set.add(ob[0] + " " + ob[1]);
        }
        int[] pos = {0, 0};
        int dir = 0;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < commands.length; i++) {
            if(commands[i] < 0) {
                if(commands[i] == -1) {
                    dir = (dir + 1) % 4;
                }else if(commands[i] == -2) {
                    dir = (dir - 1 + 4) % 4;
                }
            }else{
                int steps = commands[i];
                while(steps-- > 0 && !set.contains((pos[0] + dirs[dir][0]) + " " + (pos[1] + dirs[dir][1]))) {
                    //System.out.println("pos: " + Arrays.toString(pos));
                    pos[0] += dirs[dir][0];
                    pos[1] += dirs[dir][1];
                }
            }
            //System.out.println("pos: " + Arrays.toString(pos));
            res = Math.max(res, pos[0] * pos[0] + pos[1] * pos[1]);
        }
        return res;
    }
}
