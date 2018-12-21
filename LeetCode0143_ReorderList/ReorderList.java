package LeetCode0143_ReorderList;

public class ReorderList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode walker = head, runner = head, tail = null, l1 = head;
        while(runner != null && runner.next != null) {
            tail = walker;
            walker = walker.next;
            runner = runner.next.next;
        }
        
        tail.next = null;
        
        ListNode l2 = reverse(walker);
        
        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        while(l1 != null) {
            ListNode t1 = l1.next, t2 = l2.next;
            l1.next = l2;
            
            if(t1 == null) break;
            
            l2.next = t1;
            l1 = t1;
            l2 = t2;
        }
        
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null, cur = head, next = null;
        
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
