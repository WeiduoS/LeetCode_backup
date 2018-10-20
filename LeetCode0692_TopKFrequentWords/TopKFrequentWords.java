package LeetCode0692_TopKFrequentWords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Comparator<String> wordFre = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(map.get(s1) < map.get(s2)) {
                    return -1;
                }else if(map.get(s1) > map.get(s2)) {
                    return 1;
                }else{
                    //return 0;
                    return s2.compareTo(s1);
                }
            }
        };
        PriorityQueue<String> queue = new PriorityQueue<String>(wordFre);
        //PriorityQueue<String> heap = new PriorityQueue<String>((w1, w2) -> map.get(w1).equals(count.get(w2)) ? w2.compareTo(w1) : map.get(w1) - map.get(w2) );
        for(String word : map.keySet()) {
            queue.offer(word);
            if(queue.size() > k) queue.poll();
        }
        
        List<String> ans = new ArrayList();
        while (!queue.isEmpty()) ans.add(queue.poll());
        Collections.reverse(ans);
        return ans;
    }	
}