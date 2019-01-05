package LeetCode0636_ExclusiveTimeOfFunctions;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
	public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int len = logs.size();
        int[] res = new int[n];
        String[] start = logs.get(0).split(":");
        //System.out.println(Arrays.toString(start));
        int prev = Integer.valueOf(start[2]);
        stack.push(Integer.valueOf(start[0]));
        for(int i = 1; i < len; i++) {
            String[] f = logs.get(i).split(":");
            if(f[1].equals("start")) {
                if(!stack.isEmpty()) {
                    res[stack.peek()] += Integer.valueOf(f[2]) - prev;
                }
                stack.push(Integer.valueOf(f[0]));
                prev = Integer.valueOf(f[2]);
            }else{
                res[stack.peek()] += Integer.valueOf(f[2]) - prev + 1;
                stack.pop();
                prev = Integer.valueOf(f[2]) + 1;
            }
        }
        return res;
    }
}
