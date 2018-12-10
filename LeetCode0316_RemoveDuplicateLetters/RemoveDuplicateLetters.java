package LeetCode0316_RemoveDuplicateLetters;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
        Set<Character> set = new HashSet<>();
        int[] count = new int[26];
        for(char c : s.toCharArray()) count[c - 'a']++;
        
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            count[c - 'a']--;
            if(set.contains(c)) continue;
            
            while(!stack.isEmpty() && count[stack.peek() - 'a'] > 0 && c < stack.peek()) {
                set.remove(stack.peek());
                stack.pop();
            }
            stack.push(c);
            set.add(c);
        }
        String res = "";
        while(!stack.isEmpty()) res = stack.pop() + res;
        return res;
    }
}
