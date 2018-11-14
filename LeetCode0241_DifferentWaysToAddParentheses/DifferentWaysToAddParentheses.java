package LeetCode0241_DifferentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) return new ArrayList<>();
        return divide_conquer(input, findOperators(input));
    }
    
    private List<Integer> divide_conquer(String input, List<Integer> operators) {
        List<Integer> res = new ArrayList<>();
        if(operators.size() == 0) {
            res.add(Integer.valueOf(input));
            return res;
        }
        
        for(Integer operator : operators) {
            String left = input.substring(0, operator);
            String right = input.substring(operator + 1);
            
            List<Integer> left_nums = divide_conquer(left, findOperators(left));
            List<Integer> right_nums = divide_conquer(right, findOperators(right));
            
            for(Integer left_num : left_nums) {
                for(Integer right_num : right_nums) {
                    char c = input.charAt(operator);
                    if(c == '+') {
                        res.add(left_num + right_num);
                    }else if(c == '*') {
                        res.add(left_num * right_num);
                    }else if(c == '-') {
                        res.add(left_num - right_num);
                    }
                }
            }
        }
        
        return res;
    }

    private List<Integer> findOperators(String input) {
        List<Integer> operators = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                operators.add(i);
            }
        }
        return operators;
    }
}
