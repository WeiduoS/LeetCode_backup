package LeetCode0332_ReconstructItinerary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
	/*       JFK
     *      /   \
     *    ATL   SFO
     *    /     /
     *   JFK   ATL
     *         /
     *        SFO
     */
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();
        
        for(String[] FT : tickets) {
            String from = FT[0];
            String to = FT[1];
            if(!map.containsKey(from)) {
                map.put(from, new PriorityQueue<>());
            }
            map.get(from).offer(to);
        }
        DFS("JFK", res, map);
        return res;
    }
    // tree postorder
    private void DFS (String s, LinkedList<String> res, Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> q = map.get(s);
        
        while(q != null && !q.isEmpty()) {
            DFS(q.poll(), res, map);
        }
        
        res.addFirst(s);
    }	
}