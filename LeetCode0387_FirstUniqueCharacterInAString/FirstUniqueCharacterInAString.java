package LeetCode0387_FirstUniqueCharacterInAString;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
	// solution 1: HashMap
    public int firstUniqCharI (String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }else{
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
            //System.out.println("i: " + i + ", charAt(i): " + s.charAt(i) + ", map.get(s.charAt(i)): " + map.get(s.charAt(i)));
        }

        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;                
    }
    // solution 2: array
    public int firstUniqCharII (String s) {
        int[] count = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(count[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}