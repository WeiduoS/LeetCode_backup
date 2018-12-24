package LeetCode0282_ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0) return res;
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }
    
    private void helper(List<String> res, String exp, String num, int target, int pos, long cur, long prev) {
        if(pos == num.length()) {
            if(target == cur) {
                res.add(exp);
            }
            return;
        }
        
        for(int i = pos; i < num.length(); i++) {
            if(i != pos && num.charAt(pos) == '0') break;
            long n = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0) {
                helper(res, exp + n, num, target, i + 1, n, n);
            }else{
                helper(res, exp + "+" + n, num, target, i + 1, cur + n, n);
                helper(res, exp + "-" + n, num, target, i + 1, cur - n, -n);
                helper(res, exp + "*" + n, num, target, i + 1, cur - prev + prev * n, prev * n);
            }
        }
    }
}
