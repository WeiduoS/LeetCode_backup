package LeetCode0208_ImplementTriePrefixTree;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	class TrieNode{
        public boolean isWord;
        public Map<Character, TrieNode> childrenMap = new HashMap<>();
    }
     private TrieNode root; 
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.childrenMap.containsKey(c)) {
                 cur.childrenMap.put(c, new TrieNode());
            }
            cur = cur.childrenMap.get(c); 
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.childrenMap.containsKey(c)) {
                 return false;
            }
            cur = cur.childrenMap.get(c); 
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(!cur.childrenMap.containsKey(c)) {
                return false;
            }
            cur = cur.childrenMap.get(c); 
        }
        return true;
    }	
}