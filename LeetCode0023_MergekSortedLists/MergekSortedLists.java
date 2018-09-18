package LeetCode0023_MergekSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	// solution 1: divide and conquer
    /*
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return mergeSort(lists, 0, lists.length - 1);
    }

    public ListNode mergeSort(ListNode[] lists, int start, int end) {
        if(start == end) return lists[start];
        int middle = start + (end - start) / 2;
        ListNode first = mergeSort(lists, start, middle);
        ListNode second = mergeSort(lists, middle + 1, end);
        return merge(first, second);
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }*/
    
    // solution 2: priority queue
     public ListNode mergeKLists(ListNode[] lists) {
         if(lists == null || lists.length == 0) return null;
         PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
             @Override
        	 public int compare(ListNode o1, ListNode o2) {
                 if(o1.val < o2.val) {
                     return -1;
                 }else if(o1.val == o2.val){
                     return 0;
                 }else{
                     return 1;
                 }
             }
         });

         
         ListNode dummy = new ListNode(0);
         ListNode curr = dummy;
         for(ListNode node : lists) {
            if(node != null) queue.add(node);   
         }
         while(!queue.isEmpty()) {
             curr.next = queue.poll();
             curr = curr.next;
             if(curr.next != null) {
                 queue.add(curr.next);
             }
         }
         return dummy.next;
     }	
}