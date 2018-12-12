package LeetCode0844_BackspaceStringCompare;

public class BackspaceStringCompare {
	// solution 1: stack
    /*
    public boolean backspaceCompare(String S, String T) {
        return helper(S).equals(helper(T));
    }
    
    private String helper(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(!stack.empty() && c == '#') stack.pop();
            if(c != '#') stack.push(c);
        }
        return String.valueOf(stack);
    }*/
    
    // solution 2: two pointers
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j  = T.length() - 1;
        int skipS = 0, skipT = 0;
        while(i >= 0 || j >= 0) {
            while(i >= 0) {
                if(S.charAt(i) == '#') {
                    skipS++;
                    i--;
                }else if(skipS > 0) {
                    i--;
                    skipS--;
                }else{
                    break;
                }
            }
            
            while(j >= 0) {
                if(T.charAt(j) == '#') {
                    skipT++;
                    j--;
                }else if(skipT > 0) {
                    j--;
                    skipT--;
                }else{
                    break;
                }
            }
            
            
            if(i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) return false;
            if ((i >= 0) != (j >= 0))
                return false;
            i--;
            j--;
            
        }
        return true;
    }
}
