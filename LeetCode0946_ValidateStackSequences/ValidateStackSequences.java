package LeetCode0946_ValidateStackSequences;

import java.util.Stack;

public class ValidateStackSequences {
	/*
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length != popped.length) return false;
        Stack<Integer> stack = new Stack<>();
        int push_index, pop_index;
        for(push_index = 0, pop_index = 0; push_index < pushed.length; push_index++) {
            // push until find the pop
            //System.out.println("pushed[push_index]: " + pushed[push_index]);
            //System.out.println("popped[pop_index]: " + popped[pop_index]);
            while(push_index < pushed.length && pushed[push_index] != popped[pop_index]) {
                stack.push(pushed[push_index]);
                push_index++;
            }
            // push and pop
            if(push_index < pushed.length) stack.push(pushed[push_index]);
            while(!stack.isEmpty() && pop_index < popped.length) {
                //System.out.println("pushStack: " + stack.peek() + ", popped[pop_index]: " + popped[pop_index]);
                if(stack.peek() == popped[pop_index]) {
                    stack.pop();
                    pop_index++;
                }else{
                    break;
                }
            }
        }
        
        while(!stack.isEmpty() && pop_index < popped.length) {
            //System.out.println("stack: " + stack.peek() + ", popped[pop_index]: " + popped[pop_index]);
            if(stack.pop() != popped[pop_index]) return false;
            pop_index++;
        }
        
        return true;
    }*/
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack();

        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == N;
    }
}
