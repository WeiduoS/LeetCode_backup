package LeetCode0328_OddEvenLinkedList;


public class OddEvenLinkedList{
	
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
	
	public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null){ 
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next; 
        }
        odd.next = evenHead;
        return head;
        
    }
	
	
	
	public static void main(String[] args) {
		OddEvenLinkedList list = new OddEvenLinkedList();
        list.head = list.new ListNode(1);
        list.head.next = list.new ListNode(2);
        list.head.next.next = list.new ListNode(3);
        list.head.next.next.next = list.new ListNode(4);
         
        System.out.println("Given Linked list");
        list.printList(list.head);
        System.out.println(" ");
        ListNode head1 = list.oddEvenList(list.head);
        System.out.println("");
        System.out.println("Odd Even Linked List");
        list.printList(head1);

    }
	
	
	
	
}