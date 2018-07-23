package LeetCode0206_ReverseLinkedList;


public class ReverseLinkedList{
	
	ListNode head;
	
	class ListNode {
		int data;
        ListNode next;
        ListNode(int d) {
            data = d;
            next = null;
        }
    }
	
	void printList(ListNode node) {
		ListNode dummy = node;
        while (dummy != null) {
            System.out.print(dummy.data + " ");
            dummy = dummy.next;
        }
    }
	
	public ListNode reverseListIterI(ListNode head) {
        if(head == null) return null;
        ListNode dummy = head.next;
        ListNode newHead = head;
        
        while(head.next != null){
            head.next = dummy.next;
            dummy.next = newHead;
            newHead = dummy;
            dummy = head.next;       
        }
        return newHead;
    }
	
	public ListNode reverseListIterII(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
	
	public ListNode reverseListRecur(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseListRecur(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
	
	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
        list.head = list.new ListNode(85);
        list.head.next = list.new ListNode(15);
        list.head.next.next = list.new ListNode(4);
        list.head.next.next.next = list.new ListNode(20);
         
        System.out.println("Given Linked list");
        list.printList(list.head);
        System.out.println(" ");
        ListNode head1 = list.reverseListIterI(list.head);
        System.out.println("");
        System.out.println("Reversed linked list");
        list.printList(head1);

    }
	
	
	
	
}