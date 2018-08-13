package LeetCode0346_MovingAverageFromDataStream;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {
	 Queue<Integer> queue;
	    int len;
	    double sum = 0.0;
	    /** Initialize your data structure here. */
	    public MovingAverageFromDataStream(int size) {
	        queue = new LinkedList<Integer>();
	        len = size;
	    }
	    
	    public double next(int val) {
	        if(queue.size() == len) {
	            sum = sum - queue.poll();
	        }
	        queue.offer(val);
	        sum = sum + val;
	        return sum / queue.size();
	    }
}