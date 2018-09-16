package LeetCode0227_BasicCalculatorII;

public class BasicCalculatorII {
	// solution 1: stack
    /*
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        char sign = '+';
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                //System.out.println("nums:" + num);
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() -1) {
                //System.out.println("sign: " + s.charAt(i) + ", num" + num);
                if(sign == '+') stack.push(num);
                if(sign == '-') stack.push(-num);
                if(sign == '*') stack.push(stack.pop() * num);
                if(sign == '/') stack.push(stack.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        for(int i:stack){
            res += i;
        }
        return res;
    }*/
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.replaceAll(" ", "");
        int len = s.length();
        int res = 0;
        int preVal = 0;
        char sign = '+';
        int i = 0;
        
        while(i < len) {
            int curVal = 0;
            while(i < len && Character.isDigit(s.charAt(i))) {
                curVal = curVal * 10 + s.charAt(i) - '0';
                i++;
            }
            if(sign == '+') {
                res += preVal;
                preVal = curVal;
            }else if(sign == '-') {
                res += preVal;
                preVal = -curVal;
            }else if(sign == '*') {
                preVal = preVal * curVal;
            }else if(sign == '/') {
                preVal = preVal / curVal;
            }
            if(i < len) sign = s.charAt(i++);
        }
        res += preVal;
        return res;
    }	
}