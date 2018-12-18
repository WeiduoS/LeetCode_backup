package LeetCode0777_SwapAdjacentInLRString;

public class SwapAdjacentInLRString {
	public boolean canTransform(String start, String end) {
        int n = start.length(), i = 0, j = 0;
        while(i < n && j < n) {
            while(i < n && start.charAt(i) == 'X') i++;
            while(j < n && end.charAt(j) == 'X') j++;
            if ((i < n) ^ (j < n)) return false;
            if(i < n && j < n) {
                if(start.charAt(i) != end.charAt(j) || ( start.charAt(i) == 'L' && i < j) || (start.charAt(i) == 'R' && i > j)) 
                    return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
