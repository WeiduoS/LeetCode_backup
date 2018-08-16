package leetCode0150_EvaluateReversePolishNotation;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int first = 0;
        int second = 0;
        for(String s : tokens) {
            switch(s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second - first);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second / first);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break; 
            }
        }
        return stack.pop();
    }	
}