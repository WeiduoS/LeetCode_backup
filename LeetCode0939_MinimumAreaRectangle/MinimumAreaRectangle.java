package LeetCode0939_MinimumAreaRectangle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumAreaRectangle {
	public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] p : points) {
            if(!map.containsKey(p[0])) map.put(p[0], new HashSet<>());
            map.get(p[0]).add(p[1]);
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if(i == j) continue;
                if(points[i][0] == points[j][0] || points[i][1] == points[j][1]) continue;
                if(map.get(points[i][0]).contains(points[j][1]) && map.get(points[j][0]).contains(points[i][1])) {
                    res = Math.min(res, Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]));
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
