package LeetCode0224_BasicCalculator;

import java.util.Stack;

public class BasicCalculator {
//  Time Limit Exceeded
    /*
    static int precedence (char c) {
        switch(c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    
    private String infixToPrefix(String exp) {
        String res = "";
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if(c == ' ') continue;
            if(Character.isLetterOrDigit(c)) {
                int sum = c - '0';
                while(i + 1 < exp.length() && Character.isLetterOrDigit(exp.charAt(i + 1))) {
                    sum = sum * 10 + exp.charAt(i + 1) - '0';
                    i++;
                }
                res += sum + " ";
            }else if(c == '(') {
                stack.push(c);
            }else if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    res += stack.pop() + " ";
                }
                
                if(!stack.isEmpty() && stack.peek() != '(') {
                    return "";
                }else{
                    stack.pop();
                }
                
            }else{
                while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    res += stack.pop() + " ";
                }
                stack.push(c);
            }
        }
        
        while(!stack.isEmpty()) res += stack.pop() + " ";
        
        return res;
    }
    
    public int calculate(String s) {
        String prefix = infixToPrefix(s);
        //System.out.println(prefix);
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(Character.isDigit(c)) {
                int sum = c - '0';
                while(i + 1 < prefix.length() && Character.isDigit(prefix.charAt(i + 1))) {
                    sum = sum * 10 + prefix.charAt(i + 1) - '0';
                    i++;
                }
                stack.push(sum);
            }else{
                if(c == '+') {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(first + second);
                }else if(c == '-') {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second - first);
                }
            }
        }
        
        
        return stack.pop();
    }*/
    
    public int calculate(String s) {
        int len = s.length(), sign = 1, res= 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                int sum = c - '0';
                while(i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += sum * sign;
            }else if(c == '+') {
                sign = 1;
            }else if(c == '-') {
                sign = -1;
            }else if(c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }else if (c == ')') {
			    res = res * stack.pop() + stack.pop();
		    }
        }
        
        return res;
    }
}
