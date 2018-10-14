package LeetCode0084_LargestRectangleInHistogram;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i = 0; i < heights.length;) {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            }else{
                int top = stack.pop();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()) {
                    area = heights[top] * i;
                }else{
                    //if stack is not empty then everythin from i-1 to input.peek() + 1
                    //has to be greater or equal to input[top]
                    //so area = input[top]*(i - stack.peek() - 1);
                    area = heights[top] * (i - stack.peek() - 1);
                }
                maxArea = Math.max(maxArea, area);

            }
        }
        while(!stack.isEmpty()) {
            int top = stack.pop();
            if(stack.isEmpty()) {
                area = heights[top] * i;
            }else{
                area = heights[top] * (i - stack.peek() - 1);
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }	
}