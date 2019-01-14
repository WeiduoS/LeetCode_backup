package LeetCode0772_BasicCalculatorIII;

import java.util.Stack;

public class BasicCalculatorIII {
	public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        int n = s.length();
        int num = 0;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = s.charAt(i) - '0';
                while(i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(++i) - '0';
                }
                //System.out.println(num + "   ");
                numStack.push(num);
                
            }else if(c == '(') {
                opStack.push(c);
            }else if(c == ')') {
                while(opStack.peek() != '(') {
                    numStack.push(calculate(numStack.pop(), numStack.pop(), opStack.pop()));
                }
                opStack.pop();
            }else if(c == '+' || c == '-' || c == '*' || c == '/') {
                while(!opStack.isEmpty() && priority(c) <= priority(opStack.peek())) {
                    numStack.push(calculate(numStack.pop(), numStack.pop(), opStack.pop()));
                }
                opStack.push(c);
            }else{
                continue;
            }
        }
        while(!opStack.isEmpty()) {
            numStack.push(calculate(numStack.pop(), numStack.pop(), opStack.pop()));
        }
        return numStack.pop();
    }
    private int calculate(int a, int b, char op) {
        if(op == '+') return b + a;
        else if(op == '-') return b - a;
        else if(op == '*') return b * a;
        else return b / a;
    }
    private int priority(char c) {
        switch(c) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
		}
		return 0;
    }
}
