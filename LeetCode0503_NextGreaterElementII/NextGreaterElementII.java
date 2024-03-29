package LeetCode0503_NextGreaterElementII;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
	 public int[] nextGreaterElements(int[] nums) {
	        int n = nums.length;
	        int[] res = new int[n];
	        Arrays.fill(res, -1);
	        Stack<Integer> stack = new Stack<>();
	        for(int i = 0; i < 2 * n; i++) {
	            int num = nums[i % n];
	            while(!stack.isEmpty() && num > nums[stack.peek()]) {
	                res[stack.pop()] = num;
	            }
	            if(i < n) stack.push(i);
	        }
	        
	        return res;
	    }
}
