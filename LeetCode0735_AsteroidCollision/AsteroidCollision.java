package LeetCode0735_AsteroidCollision;

import java.util.Stack;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids) {
            if(asteroid > 0) {
                stack.push(asteroid);
            }else{
                if(stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }else{
                    boolean crash = false;
                    while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() <= Math.abs(asteroid)) {
                        if(stack.peek() == Math.abs(asteroid)) {
                            stack.pop();
                            crash = true;
                            break;
                        }else{
                            stack.pop();
                        }
                    }
                    if((stack.isEmpty() || stack.peek() < 0) && !crash) stack.push(asteroid);
                }
            }
            //for(int i : stack) System.out.print(i + ", ");
            //System.out.println("-----");
        }
        int[] res = new int[stack.size()];
        int index = 0;
        for(int i : stack) res[index++] = i;
        return res;
	}
}
