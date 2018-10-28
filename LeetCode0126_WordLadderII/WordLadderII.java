package LeetCode0126_WordLadderII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	Map<String, List<String>> map;
    List<List<String>> result;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        result = new ArrayList<List<String>>();
        Set<String> dict = new HashSet<>(wordList);
        if(dict.size() == 0 || !dict.contains(endWord)) return result;
        
        int min = Integer.MAX_VALUE;
        
        map = new HashMap<String, List<String>>();
        Map<String, Integer> ladder = new HashMap<>();
        for(String word : dict) ladder.put(word, Integer.MAX_VALUE);
        
        Queue<String> queue = new LinkedList<>();
        
        ladder.put(beginWord, 0);
        queue.add(beginWord);
        
        // BFS: Dijisktra search
        while(!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word) + 1;
            if(step > min) break;
            for(int i = 0; i < word.length(); i++) {
                char[] tempWord = word.toCharArray();
                for(char c = 'a'; c <= 'z'; c++) {
                    tempWord[i] = c;
                    String newWord = new String(tempWord);
                    if(!ladder.containsKey(newWord)) continue;
                    if(ladder.containsKey(newWord)) {
                    }
                    if(ladder.get(newWord) < step) {
                        continue;
                    }else if(ladder.get(newWord) > step){ //It is a KEY line. If one word already appeared in one ladder
                        queue.add(newWord); // Do not insert the same word inside the queue twice. Otherwise it gets TLE.
                        ladder.put(newWord, step);
                    }

                    if(map.containsKey(newWord)) {
                        map.get(newWord).add(word);
                    }else{
                        map.put(newWord,new LinkedList<String>(Arrays.asList(new String[]{word})));
                        /*
                        List<String> list = new ArrayList<String>();
                        list.add(word);
                        map.put(newWord, list);*/
                    }
                    
                    if(newWord.equals(endWord)) min = step;
                }
            }
        }
        /*
        for(Map.Entry<String,List<String>> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", value: " + Arrays.toString(entry.getValue().toArray()));
        }*/
        DFS(endWord, beginWord, new ArrayList<>());
        return result;  
    }
    
    private void DFS(String endWord, String beginWord, List<String> temp) {
        if(endWord.equals(beginWord)) {
            temp.add(0, endWord);
            result.add(new ArrayList<String>(temp));
            temp.remove(0);
            return;
        }
        
        temp.add(0, endWord);
        if(map.get(endWord) != null) {
            for(String word : map.get(endWord)) DFS(word, beginWord, temp);
        }
        temp.remove(0);
    }	
}