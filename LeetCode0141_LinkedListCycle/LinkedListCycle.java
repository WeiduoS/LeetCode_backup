package LeetCode0141_LinkedListCycle;

public class LinkedListCycle{
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner != null && runner.next != null){
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner) return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		LinkedListCycle linkedList = new LinkedListCycle();
		ListNode head = linkedList.new ListNode(0);
		head.next = linkedList.new ListNode(2);
		head.next.next = head;
		System.out.println(linkedList.hasCycle(head));
		
		
	}
}