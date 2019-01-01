package LeetCode0819_MostCommonWord;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        
        Set<String> set = new HashSet<>();
        for(String ban : banned) set.add(ban);
        Map<String, Integer> map = new HashMap<>();
        
        String word = "";
        int max = Integer.MIN_VALUE;
        String res = "";
        for(char c : paragraph.toCharArray()) {
            if(Character.isLetter(c)) {
                word += c;
            }else if(word.length() > 0) {
                word = word.toLowerCase();
                if(!set.contains(word)){
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    if(map.get(word) > max) {
                        max = map.get(word);
                        res = word;
                    }
                }
                word = "";
            }
        }
        /*
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("word: " + entry.getKey() +", value: " + entry.getValue());
        }*/
        return res;
    }
}
