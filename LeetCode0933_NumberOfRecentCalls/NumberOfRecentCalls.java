package LeetCode0933_NumberOfRecentCalls;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {
	Queue<Integer> q;
    public void RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        q.offer(t);
        while(q.peek() < t - 3000) q.poll();
        return q.size();
    }
}
