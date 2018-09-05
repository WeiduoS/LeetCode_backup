package LeetCode0212_WordSearchII;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
	class Trie{
        Trie[] children = new Trie[26];
        String word;
    }
    
    private Trie buildTrie (String[] words) {
        Trie root = new Trie();
        
        for(String w : words) {
            Trie cur = root;
            for(char c : w.toCharArray()) {
                if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Trie();
                cur = cur.children[c - 'a'];
            }
            cur.word = w;
        }
        return root;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        Trie root = buildTrie(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, list);
            }
        }
        return list;
    }
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
    private void dfs(char[][] board, int i, int j, Trie root, List<String> list) {
        if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) return;
        char c = board[i][j];
        if(c == '#' || root.children[c - 'a'] == null) return;
        root = root.children[c - 'a'];
        if(root.word != null) {
            list.add(root.word);
            root.word = null;
        }
        
        board[i][j] = '#';
        for(int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            dfs(board, row, col, root, list);
        }
        board[i][j] = c;
        
    }	
}