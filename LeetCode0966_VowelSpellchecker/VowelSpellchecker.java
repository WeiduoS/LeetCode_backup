package LeetCode0966_VowelSpellchecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VowelSpellchecker {
	Set<String> orig;
    Map<String, String> lower;
    Map<String, String> vows;
    public String[] spellchecker(String[] wordlist, String[] queries) {
        orig = new HashSet<>();
        lower = new HashMap<>();
        vows = new HashMap<>();
        
        for(String word : wordlist) {
            
            orig.add(word);

            String l = word.toLowerCase();
            lower.putIfAbsent(l, word);

            String v = geneVowel(l);
            vows.putIfAbsent(v, word);
            
        }
        
        String[] res = new String[queries.length];
        int i = 0;
        for(String query : queries) {
            res[i++] = check(query);
        }
        return res;
    }
    
    private String check(String word) {
        if(orig.contains(word)) return word;
        
        String l = word.toLowerCase();
        if(lower.containsKey(l)) return lower.get(l);
        
        String v = geneVowel(l);
        if(vows.containsKey(v)) return vows.get(v);
        
        return "";
    }
    
    private String geneVowel(String word) {
        StringBuilder sb = new StringBuilder();
        for(char c : word.toCharArray()) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                sb.append('*');
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
