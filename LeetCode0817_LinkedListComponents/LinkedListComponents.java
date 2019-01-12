package LeetCode0817_LinkedListComponents;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
	/*
    public int numComponents(ListNode head, int[] G) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int v : G) {
            set.add(v);
            map.put(v, new ArrayList<>());
        }
        ListNode f = head;
        ListNode s = null;
        while(f.next != null) {
            s = f.next;
            if(set.contains(f.val) && set.contains(s.val)) {
                //System.out.println("f.val: " + f.val + ", s.val: " + s.val);
                map.get(f.val).add(s.val);
                map.get(s.val).add(f.val);
            }
            f = s;
        }
        
        int res = 0;
        Set<Integer> visited = new HashSet<>();
        for(int v : G) {
            if(visited.contains(v)) continue;
            res++;
            DFS(map, v, visited);
        }
        return res;
    }
    
    private void DFS(Map<Integer, List<Integer>> map, int cur, Set<Integer> visited) {
        //System.out.println("cur: " + cur);
        if(visited.contains(cur)) return;
        visited.add(cur);
        for(int neigh : map.get(cur)) {
            DFS(map, neigh, visited);
        }
    }*/
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for(int v : G) set.add(v);
        int res = 0;
        while(head != null) {
            if(set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) res++;
            head = head.next;
        }
        return res;
    }
}
