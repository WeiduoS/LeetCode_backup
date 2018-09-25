package LeetCode0269_AlienDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienDictionary {
	public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int[] charStatus = new int[26];
        List<List<Integer>> adj = buildGraph(words, charStatus);
        for(int i = 0; i < charStatus.length; i++) {
            if(charStatus[i] == 0) {
                if(!dfs(adj, i, sb, charStatus)) return "";
            }
        }
        return sb.reverse().toString();
    }
    private boolean dfs (List<List<Integer>> adj, int i, StringBuilder sb, int[] charStatus) {
        if(charStatus[i] == 1) return false;
        if(charStatus[i] == 2) return true;
        charStatus[i] = 1;
        for(int neighbor : adj.get(i)) {
            if(!dfs(adj, neighbor, sb, charStatus)) return false;
        }
        sb.append((char)(i + 'a'));
        charStatus[i] = 2;
        return true;
    }
    
    private List<List<Integer>> buildGraph(String[] words, int[] charStatus) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            adj.add(new ArrayList());
        }
        Arrays.fill(charStatus, -1);    
        int n = words.length;
        for(int i = 0; i < n; i++) {
            for(char c : words[i].toCharArray()) charStatus[c - 'a'] = 0;
            if(i >= 1) {
                char[] first = words[i - 1].toCharArray();
                char[] second = words[i].toCharArray();
                int shortLen = Math.min(first.length, second.length);
                for(int j = 0; j < shortLen; j++) {
                    if(first[j] != second[j]) {
                        adj.get(first[j] - 'a').add(second[j] - 'a');
                        break;
                    }
                }
                
            }
        }
        return adj;
    }	
}