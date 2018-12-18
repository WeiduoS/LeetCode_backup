package LeetCode0472_ConcatenatedWords;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {
	/*
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if(words.length <= 1) return new ArrayList<String>();
        Set<String> set = new HashSet<>();
        for(String word : words) set.add(word);
        List<String> list = new ArrayList<>();
        for(String word : words) {
            set.remove(word);
            // "" is not work
            int n = word.length();
            if(n == 0) continue;
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for(int i = 1; i <= n; i++) {
                for(int j = 0; j < i; j++) {
                    if(dp[j] && set.contains(word.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            if(dp[dp.length - 1]) list.add(word);
            set.add(word);
        }
        return list;
    }*/
    class Tries {
        Tries[] children;
        String isWord;
        public Tries() {
            children = new Tries[26];
        }
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<>();
        if(words.length <= 1) return list;
        
        Tries root = new Tries();
        for(String word : words) {
            if(word.length() == 0) continue;
            add(word, root);
        }
        
        for(String word : words) {
            if(word.length() == 0) continue;
            if(find(word.toCharArray(), 0, root)) list.add(word);
        }
        return list;
    }
    
    private boolean find(char[] word, int pos, Tries root) {
        Tries cur = root;
        for(int i = pos; i < word.length; i++) {
            if(cur.children[word[i] - 'a'] == null) return false;
            
            cur = cur.children[word[i] - 'a'];
            
            if(cur.isWord != null && !cur.isWord.equals(word)) {
                if(find(word, i + 1, root)) return true;
            }
        }
        return pos != 0 && cur.isWord != null;   
    }
    private void add(String word, Tries root) {
        for(char c : word.toCharArray()) {
            if(root.children[c - 'a'] == null) root.children[c - 'a'] = new Tries();
            root = root.children[c - 'a'];
        }
        root.isWord = word;
    }
}
