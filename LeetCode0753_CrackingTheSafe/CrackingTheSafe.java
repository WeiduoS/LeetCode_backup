package LeetCode0753_CrackingTheSafe;

import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe {
	public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int total = (int) Math.pow(k, n);
        for(int i = 0; i < n; i++) sb.append('0');
        
        Set<String> set = new HashSet<>();
        set.add(sb.toString());
        
        dfs(sb, total, set, n, k);
        
        return sb.toString();
    }
    
    private boolean dfs(StringBuilder sb, int total, Set<String> set, int n, int k) {
        if(set.size() == total) return true;
        String prev = sb.substring(sb.length() - n + 1, sb.length());
        
        for(int i = 0; i < k; i++) {
            String next = prev + i;
            if(!set.contains(next)) {
                set.add(next);
                sb.append(i);
                if(dfs(sb, total, set, n, k)) return true;
                else{
                    set.remove(next);
                    sb.delete(sb.length() - 1, sb.length());
                }
            }
        }
        return false;
    }
}
