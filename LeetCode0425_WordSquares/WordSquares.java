package LeetCode0425_WordSquares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSquares {
	class Trie {
        String word;
        Trie[] children;
        Trie() {
            this.word = "";
            this.children = new Trie[26];
        }
    } 
    
    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for(String word : words) {
            Trie cur = root;
            for(char c : word.toCharArray()) {
                if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Trie();
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
        return root;
    }
    /*
     * 第0行。
     * 开始    prefix[root, root, root, root] 
     * (0, 0) prefix[root, root, root, root]  (root.w, root.w)  root[0] = w, root[0] = w
     * (0, 1) prefix[w, root, root, root]     (w.a, root.a)     root[0] = wa, root[1] = a
     * (0, 2) prefix[wa, a, root, root]     (wa.l, root.l)     root[0] = wal, root[2] = l
     * (0, 3) prefix[wal, a, l, root]     (wal.l, root.l)     root[0] = wall, root[3] = l
     * 结束     prefix[wall, a, l, l] 
     * 
     * 第1行。
     * 开始    prefix[wall, a, l, l]
     * 
     * (1,1)  prefix[wall, a, l, l]       (a.r, a.r)     root[1] = ar,  root[1] = ar
     * (1,2)  prefix[wall, ar, l, l]      (ar.e, l.e)    root[1] = are, root[2] = le
     * (1,3)  prefix[wall, are, le, l]      (are.a, l.a)    root[1] = area, root[3] =la
     * 结束    prefix[wall, area, le, la]   
     */
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(words == null || words.length == 0) return res;
        Trie root = buildTrie(words);
        
        Trie[] prefix = new Trie[words[0].length()];
        Arrays.fill(prefix, root);
        dfs(0, 0, prefix, res);
        return res;
        
    }
    
    private void dfs(int row, int col, Trie[] prefix, List<List<String>> res) {
        if(row == prefix.length) {
            List<String> temp = new ArrayList<String>();
            for(int i = 0; i < prefix.length; i++) {
                temp.add(prefix[i].word);
            }
            res.add(temp);
        }else if(col < prefix.length) {
            Trie curRow = prefix[row];
            Trie curCol = prefix[col];
            for(int i = 0; i < 26; i++) {
                if(curRow.children[i] != null && curCol.children[i] != null) {
                    prefix[row] = curRow.children[i];
                    prefix[col] = curCol.children[i];
                    dfs(row , col + 1, prefix, res);
                }
            }
            prefix[row] = curRow;
            prefix[col] = curCol;
        }else{
            dfs(row + 1 , row + 1, prefix, res);
        }
    }	
}