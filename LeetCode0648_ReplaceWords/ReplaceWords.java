package LeetCode0648_ReplaceWords;

import java.util.List;

public class ReplaceWords {
	/*
    public String replaceWords(List<String> dict, String sentence) {
        Set<String> rootset = new HashSet<>();
        for(String s : dict) rootset.add(s);
        
        StringBuilder sb = new StringBuilder();
        for(String word : sentence .split("\\s+")) {
            String prefix = "";
            for(int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if(rootset.contains(prefix)) break;
            }
            if(sb.length() > 0) sb.append(" ");
            sb.append(prefix);
        }
        return sb.toString();
    }*/
    class TrieNode {
        TrieNode[] children;
        String word;
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode trie = new TrieNode();
        for(String s : dict) {
            TrieNode cur = trie;
            for(char c : s.toCharArray()) {
                if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
            cur.word = s;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : sentence.split("\\s+")) {
            if(sb.length() > 0) sb.append(" ");
            TrieNode cur = trie;
            for(char c : s.toCharArray()) {
                if(cur.children[c - 'a'] == null || cur.word != null) break;
                cur = cur.children[c - 'a'];
            }
            sb.append(cur.word == null? s : cur.word);
        }
        return sb.toString();
    }	
}