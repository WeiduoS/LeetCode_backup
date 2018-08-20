package LeetCode0394_DecodeString;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) > '0' && s.charAt(i) <= '9') {
                int numStart = i;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    i++;
                }
                stack.push(String.valueOf(s.substring(numStart, i)));
                i--;
            }else if(s.charAt(i) == '[') {
                i++;
                int strStart = i;
                while((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                    i++;
                }
                stack.push(s.substring(strStart, i));
                i--;
            }else if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                int charStart = i;
                while(i < s.length() && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    i++;
                }
                stack.push(s.substring(charStart, i));
                i--;
            }else if(s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(stack.pop());
                while(!isNumeric(stack.peek())) {
                   sb.insert(0, stack.pop());
                }
                int times = Integer.valueOf(stack.pop());
                String temp = sb.toString();
                for(int j = 0 ; j < times - 1; j++) {
                    sb = sb.append(temp);
                }
                stack.push(sb.toString());
            }
        }
        
        while(!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
    
    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}