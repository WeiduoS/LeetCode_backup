package LeetCode0752_OpenTheLock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
	public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for(String s : deadends) dead.add(s);
        if(dead.contains("0000")) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        
        Set<String> visit = new HashSet<>();
        visit.add("0000");
        
        int steps = 0;
        while(!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for(int count = 0; count < size; count++) {
                String curr = queue.poll();
                for(int i = 0; i < 4; i++) {
                    for(int j = -1; j<=1; j+=2) {
                        int c = (curr.charAt(i) - '0' + j + 10) % 10;
                        String next = curr.substring(0, i) + ("" + c) + curr.substring(i+1);
                        //System.out.println(next);
                        if(next.equals(target)) return steps;
                        if(visit.contains(next) || dead.contains(next))  continue;
                        queue.offer(next);
                        visit.add(next);
                    }
                }
            }
        }
        return -1;
    }
}