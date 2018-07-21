package LeetCode0142_LinkedListCycleII;

public class LinkedListCycleII{
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode begin = head;
                while(begin != slow){
                    slow = slow.next;
                    begin = begin.next;
                }
                return slow;
            }
        }
        return null;
    }
}