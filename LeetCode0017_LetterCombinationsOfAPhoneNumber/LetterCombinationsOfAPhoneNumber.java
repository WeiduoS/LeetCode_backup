package LeetCode0017_LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
        String[] str = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs","tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        dfs(digits, str, 0, res, "");
        return res;
    }
    private void dfs(String digits, String[] str, int level, List<String> res, String temp) {
        if(level == digits.length()) {
            res.add(temp);
            return;
        }
        for(char c : str[digits.charAt(level) - '0'].toCharArray()) {
            dfs(digits, str, level + 1, res, temp +  Character.toString(c));
        }
    }	
}