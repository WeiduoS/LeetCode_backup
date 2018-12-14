package LeetCode0833_FindAndReplaceInString;

import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString {
	class Append {
        int len;
        String str;
        Append(int len, String str) {
            this.len = len;
            this.str = str;
        }
    }
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, Append> map = new HashMap<>();
        String res = "";
        
        for(int i = 0; i < indexes.length; i++) {
            int index = indexes[i];
            if(S.substring(index, index + sources[i].length()).equals(sources[i])) {
                map.put(index, new Append(sources[i].length(), targets[i]));
            }
        }
        
        for(int i = 0; i < S.length(); ){
           if(map.containsKey(i)) {
               res += map.get(i).str;
               i += map.get(i).len;
           }else{
               res += S.charAt(i);
               i++;
           }
        }
        
        return res;
    }
}
