package LeetCode0336_PalindromePairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {
	/*
    class TrieNode {
        TrieNode[] children;
        int index;
        List<Integer> list;
        
        TrieNode() {
            children = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(int i = 0; i < words.length; i++) {
            TrieNode cur = root;
            for(int j = words[i].length() - 1; j >= 0; j--) {
                if(cur.children[words[i].charAt(j) - 'a'] == null) cur.children[words[i].charAt(j) - 'a'] = new TrieNode();
                if(isPalindrome(words[i], 0, j)) cur.list.add(i);
                cur = cur.children[words[i].charAt(j) - 'a'];
            }
            cur.list.add(i);
            cur.index = i;
        }
        return root;
    }
    
    private boolean isPalindrome(String word, int i, int j) {
        while(i < j) {
            if(word.charAt(i++) != word.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < words.length; i++) search(words, i, root, res);
        return res;
    }
    
    
    private void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
        for(int j = 0; j < words[i].length(); j++) {
            if(root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                res.add(Arrays.asList(i, root.index));
            }
            root = root.children[words[i].charAt(j) - 'a'];
            if(root == null) return;
        }
        for(int j : root.list) {
            if(i == j) continue;
            res.add(Arrays.asList(i, j));
        }
    }*/
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) map.put(words[i], i);
        
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j); 
                
                if(isPalindrome(str1)) {
                    String str2rev = new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(str2rev) && map.get(str2rev) != i) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(map.get(str2rev));
                        temp.add(i);
                        res.add(temp);
                    }
                }
                
                if(isPalindrome(str2) && str2.length() != 0) {
                    String str1rev = new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(str1rev) && map.get(str1rev) != i) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(map.get(str1rev));
                        res.add(temp);
                    }
                }
            }
        }
        
        return res;
    }
    
    private boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;
        while(i < j) {
            if(word.charAt(i++) != word.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}