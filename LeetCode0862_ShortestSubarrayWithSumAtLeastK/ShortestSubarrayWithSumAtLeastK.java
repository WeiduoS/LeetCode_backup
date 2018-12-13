package LeetCode0862_ShortestSubarrayWithSumAtLeastK;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarrayWithSumAtLeastK {
	public int shortestSubarray(int[] A, int K) {
        long[] preSum = new long[A.length + 1];
        
        for(int i = 1; i <= A.length; i++) {
            preSum[i] = preSum[i - 1] + (long)A[i - 1];
        }
        Deque<Integer> monoq = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < preSum.length; i++) {
            while(!monoq.isEmpty() && preSum[i] <= preSum[monoq.peekLast()]) monoq.pollLast();
            while(!monoq.isEmpty() && preSum[i] >= preSum[monoq.peekFirst()] + K) {
                ans = Math.min(ans, i - monoq.pollFirst());
            }
            monoq.offerLast(i);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
