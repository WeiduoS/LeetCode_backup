package LeetCode0019_RemoveNthNodeFromEndOfList;

public class RemoveNthNodeFromEndOfList{
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
	       ListNode dummy = new ListNode(0);
	       dummy.next = head;
	       ListNode slow = dummy;
	       ListNode fast = dummy;
	        
	       while(n != 0){
	           fast = fast.next;
	           n--;
	       }

	       while(fast.next != null){
	           slow = slow.next;
	           fast = fast.next;
	       }
	       slow.next = slow.next.next;
	    
	       return dummy.next;
	}
	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList remover = new RemoveNthNodeFromEndOfList();
		ListNode list = remover.new ListNode(1);
		list.next = remover.new ListNode(2);
		list.next.next = remover.new ListNode(3);
		list.next.next.next = remover.new ListNode(4);
		list.next.next.next.next = remover.new ListNode(5);
		
		ListNode res = remover.removeNthFromEnd(list, 2);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}

		
	}
}