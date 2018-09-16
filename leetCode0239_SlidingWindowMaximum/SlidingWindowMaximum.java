package leetCode0239_SlidingWindowMaximum;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int len = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[len - k + 1];
        for(int i = 0; i < len; i++){
            if(!deque.isEmpty() && deque.peekFirst() == i - k) deque.pollFirst();
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offerLast(i);
            if(i - k + 1 >= 0) res[i - k + 1] = nums[deque.peekFirst()];
        }  
        return res;
    }
}