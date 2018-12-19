package LeetCode0815_BusRoutes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {
	public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S == T) return 0;
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for (int j : routes[i]) {
                map.putIfAbsent(j, new HashSet<Integer>());
                map.get(j).add(i);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(int next : map.get(S)) {
            queue.offer(next);
            set.add(next);
        }
        int res = 1;
        
        while(!queue.isEmpty()) {
            Queue<Integer> temp = new LinkedList<>();
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for(int c : routes[cur]) {
                    if(c == T) return res;
                    for(int next : map.get(c)) {
                        if(!set.contains(next)) {
                            set.add(next);
                            temp.add(next);
                        }
                    }
                }
            }
            res++;
            queue = temp;
        }
        return -1;
    }
}
