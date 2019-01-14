package LeetCode0853_CarFleet;

import java.util.TreeMap;

public class CarFleet {
	public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> tree = new TreeMap<>();
        for(int i = 0; i < position.length; i++) {
            tree.put(target - position[i], (double)(target - position[i]) / speed[i]);
        }
        int res = 0;
        double time = 0;
        for(double t : tree.values()) {
            if(t > time) {
                res++;
                time = t;
            }
        }
        return res;
    }
}
