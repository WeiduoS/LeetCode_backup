package LeetCode0444_SequenceReconstruction;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SequenceReconstruction {
	/*
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if(seqs.isEmpty()) return false;
        int n = org.length, cnt = n - 1;
        int[] pos = new int[n + 1];
        int[] flags = new int[n + 1];
        boolean existed = false;
        for(int i = 0; i < n; i++) pos[org[i]] = i;
        for(List<Integer> seq : seqs) {
            for(int i = 0; i < seq.size(); i++) {
                existed = true;
                if(seq.get(i) <= 0 || seq.get(i) > n) return false;
                if(i == 0) continue;
                int pre = seq.get(i - 1), cur = seq.get(i);
                if(pos[pre] >= pos[cur]) return false;
                if(flags[cur] == 0 && pos[pre] + 1 == pos[cur]) {
                    flags[cur] = 1;
                    cnt--;
                }
            }
        }
        return cnt == 0 && existed;
    }*/
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for(List<Integer> seq : seqs) {
            if(seq.size() == 1) {
                if(!map.containsKey(seq.get(0))) {
                    map.put(seq.get(0), new HashSet<>());
                    indegree.put(seq.get(0), 0);
                }
            }else{
                for(int i = 0; i < seq.size() - 1; i++) {
                    if(!map.containsKey(seq.get(i))) {
                        map.put(seq.get(i), new HashSet<>());
                        indegree.put(seq.get(i), 0);
                    }
                    if(!map.containsKey(seq.get(i + 1))) {
                        map.put(seq.get(i + 1), new HashSet<>());
                        indegree.put(seq.get(i + 1), 0);
                    }
                    
                    if(!map.get(seq.get(i)).contains(seq.get(i + 1))) {
                        map.get(seq.get(i)).add(seq.get(i + 1));
                        indegree.put(seq.get(i + 1), indegree.get(seq.get(i + 1)) + 1);
                    }
                }
            }
        }
        /*
        for(Map.Entry<Integer,Integer> entry : indegree.entrySet()) {
            System.out.println("vertex: " + entry.getKey() + ", indegree: " + entry.getValue());
        }*/
        
        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : indegree.entrySet()) {
            if(entry.getValue() == 0) queue.offer(entry.getKey());
        }
        
        int index = 0;
        while(!queue.isEmpty()) {
            if(queue.size() > 1) return false; // case : [1,2,3] -> [[1,2],[1,3]]
            int cur = queue.poll();
            if(index == org.length || cur != org[index++]) return false;
            for(int neighbor : map.get(cur)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0) queue.offer(neighbor);
            }
        }
        // case: [1] -> [[1],[2,3],[3,2]]
        return index == org.length && index == map.size();
    }
}
