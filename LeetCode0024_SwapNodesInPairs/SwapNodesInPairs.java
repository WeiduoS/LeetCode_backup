package LeetCode0024_SwapNodesInPairs;

public class SwapNodesInPairs {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode tail = head;
        for(int i = 0; i < 1; i++) {
            tail = tail.next;
            if(tail == null) return head;
        }
        
        tail = swapPairs(tail.next);
        
        ListNode prev = tail, cur = head, next = null;
        int count = 2;
        while(count >= 1) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count--;
        }
        return prev;
    }
}
