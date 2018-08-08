package LeetCode0205_IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphicI (String s, String t) {
        
        if(s.length() != t.length()) return false;
        if(s.length() == 0 && t.length() == 0) return true;
        
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            //System.out.println("s.charAt(i):" + s.charAt(i) + ", t.charAt(i): " + t.charAt(i));
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) == t.charAt(i)) {
                    continue;
                }else{
                    return false;
                }
            }else{
                if(!map.containsValue(t.charAt(i))){
                    map.put(s.charAt(i), t.charAt(i));
                }else{
                    return false;  
                }
            }
        }
        return true; 
    }
    
    public boolean isIsomorphicII(String s, String t) {
        int[] sChars = new int[256];
        int[] tChars = new int[256];
        for(int i = 0; i < s.length(); i++){
            if(sChars[s.charAt(i)] != tChars[t.charAt(i)]){
                return false;
            }else{
                sChars[s.charAt(i)] = tChars[t.charAt(i)] = t.charAt(i);
            }
        }
        return true;
    } 

	
}