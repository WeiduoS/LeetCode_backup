package LeetCode0085_MaximalRectangle;

import java.util.Stack;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int max = 0;
        max = Math.max(max, maximalRectangleExtend(matrix[0]));
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') matrix[i][j] += matrix[i - 1][j] - '0';
                max = Math.max(max, maximalRectangleExtend(matrix[i]));
            }
        }
        return max;
    }
    
    private int maximalRectangleExtend(char[] height) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0, area = 0, i = 0;
        for(i = 0; i < height.length;) {
            if(stack.isEmpty() || height[i] - '0' >= height[stack.peek()] - '0') {
                stack.push(i++);
            }else{
                int top = height[stack.pop()] - '0';
                
                if(stack.isEmpty()) {
                    area = i * top;
                }else{
                    area = (i - stack.peek() - 1) * top;
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        while(!stack.isEmpty()) {
            int top = height[stack.pop()] - '0';
            if(stack.isEmpty()) {
                area = i * top;
            }else{
                area = (i - stack.peek() - 1) * top;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
        
    }
}
