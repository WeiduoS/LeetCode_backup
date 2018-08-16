package LeetCode0739_DailyTemperatures;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
	// solution 1: Extra Array
    public int[] dailyTemperaturesI(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for(int i = len - 1; i >=0; i--) {
            int temp = Integer.MAX_VALUE;
            for(int j = temperatures[i] + 1; j <= 100; j++) {
                if(next[j] < temp) {
                    temp = next[j];
                }
            }
            if(temp < Integer.MAX_VALUE) res[i] = temp - i;
            next[temperatures[i]] = i;
        }
        return res;
    }
    // solution 2: Stack
    public int[] dailyTemperaturesII(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = len - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty()? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}