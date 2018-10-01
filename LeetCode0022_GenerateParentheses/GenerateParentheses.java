package LeetCode0022_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        int[] count = {n, n};
        dfs(n, 0, res, count, "");
        return res;
    }
    private void dfs(int n, int level, List<String> res, int[] count, String temp) {
        
        if(n *2 == level) {
            res.add(temp);
            return;
        }
        String parentheses = "()";
        
        if(level == 0) {
            parentheses = "(";
        }else if(level == n * 2) {
            parentheses = ")";
        }else{
            parentheses = "()";
        }
        for(char c : parentheses.toCharArray()) {
            if(count[c - '('] == 0 || count[0] > count[1]) continue;
            count[c - '(']--;
            temp += c;
            dfs(n, level + 1, res, count, temp);
            count[c - '(']++;
            temp = temp.substring(0, temp.length() - 1);
        }
        return;
    }
}