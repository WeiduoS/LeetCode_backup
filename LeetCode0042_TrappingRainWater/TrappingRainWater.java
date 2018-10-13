package LeetCode0042_TrappingRainWater;

import java.util.Stack;

public class TrappingRainWater {
	// solution 1: two pointers
    /*
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        int l = 0;
        int r = n - 1;
        int res = 0;
        while(l < r) {
            leftMax = Math.max(height[l], leftMax);
            rightMax = Math.max(height[r], rightMax);
            if(leftMax < rightMax) {
                res += leftMax - height[l];
                l++;
            }else{
                res += rightMax - height[r];
                r--;
            }
        }
        return res;
    }*/
    
    // solution 2: stack
    
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        int i = 0;
        int res = 0;
        while(i < n) {
            if(stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            }else{
                int pit = stack.pop();
                if(stack.isEmpty()) continue;
                //res += (Math.min(height[i], height[stack.peek()]) - height[pit]) * (i - stack.peek() - 1);
                res += (Math.min(height[i], height[stack.peek()]) - height[pit]) * (i - stack.peek() - 1);
            }
        }
        return res;
    }	
}