package LeetCode0127_WordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //boolean hasEnd = false;
        //for(String s : wordList) {
        //    if(s.equals(endWord)) hasEnd = true;
        //}
        //if(hasEnd == false) return 0;
        Set<String> dict = new HashSet<>();
        for(String s : wordList) {
            dict.add(s);
        }
        if(!dict.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(beginWord);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for(int i = 0; i < size; i++) {
                String str = queue.poll();
                for(int j = 0; j < str.length(); j++) {
                    char[] chars = str.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String word = new String(chars);
                        if(word.equals(endWord)) return count + 1;
                        /*
                        for(String s : wordList) {
                            if(!set.contains(word) && s.equals(word)) {
                                queue.offer(word);
                                set.add(word);
                            }
                        }*/
                        if(!set.contains(word) && dict.contains(word)) {
                            queue.offer(word);
                            set.add(word);
                        }
                    }
                }
            }
        }
        return 0;
    }	
}