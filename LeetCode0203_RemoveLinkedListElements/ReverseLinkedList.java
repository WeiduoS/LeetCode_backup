package LeetCode0203_RemoveLinkedListElements;


public class ReverseLinkedList{
	
	ListNode head;
	
	class ListNode {
		int val;
        ListNode next;
        ListNode(int d) {
            val = d;
            next = null;
        }
    }
	
	void printList(ListNode node) {
		ListNode dummy = node;
        while (dummy != null) {
            System.out.print(dummy.val + " ");
            dummy = dummy.next;
        }
    }
	
	public ListNode removeElementsIter(ListNode head, int val) {
        ListNode curr = head, pre = null;
        
        while (curr != null && curr.val == val){
            head = curr.next;
            curr = head;
        }
        
        while(curr != null){
            if(curr.val == val){
                pre.next = curr.next;
                curr = curr.next;
            }else{
                pre = curr;
                curr = curr.next;
            }
        }
        return head;
    }
	
	public ListNode removeElementsRecur(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElementsRecur(head.next, val);
        return head.val == val ? head.next : head;
    }
	
	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
        list.head = list.new ListNode(85);
        list.head.next = list.new ListNode(15);
        list.head.next.next = list.new ListNode(4);
        list.head.next.next.next = list.new ListNode(20);
         
        System.out.println("Given Linked list");
        list.printList(list.head);
        ListNode head1 = list.removeElementsIter(list.head, 85);
        ListNode head2 = list.removeElementsRecur(list.head, 15);
        System.out.println("");
        System.out.println("Reverse Linked List");
        list.printList(head1);
        System.out.println("");
        System.out.println("Reverse Linked List again");
        list.printList(head2);

    }
	
	
	
	
}