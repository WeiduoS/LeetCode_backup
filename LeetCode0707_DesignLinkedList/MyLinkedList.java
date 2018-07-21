package LeetCode0707_DesignLinkedList;

public class MyLinkedList {
    
    int length;
    Node head;
    
    class Node{
        int val;
        Node next;
        Node(int x){
            this.val = x;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.length = 0;
        this.head = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= this.length ){
            return -1;
        }else{
            int counter = 0;
            Node curr = head;
            while(counter != index){
                curr = curr.next;
                counter++;
            }
            return curr.val;
        }
    }

    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node curr = this.head;
        if(curr == null) {
            this.head = new Node(val);
        }else{
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = new Node(val);
        }
        this.length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        int counter = 0;
        Node newNode = new Node(val);
        Node curr = head;
        
        if(index < 0 || index > this.length){
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        while(counter != (index - 1)){
            curr = curr.next;
            counter++;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        this.length++;
    }

    
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= this.length){
            return;
        }
        Node curr = head;
        int counter = 0;
        
        if(index == 0){
            head = curr.next;
        }else{
            Node pre = null;
            while(counter != index){
                pre = curr;
                curr = curr.next;
                counter++;
            }
            pre.next = curr.next;
            //curr.next = curr.next.next;
            this.length--;
        }
    }
    public void printList()
	{
		Node tnode = head;
		while (tnode != null)
		{
			System.out.print(tnode.val+" ");
			System.out.println(" ");
			tnode = tnode.next;
		}
	}
     public static void main(String[] args) {
    	 MyLinkedList linkedList = new MyLinkedList(); 
    	 System.out.println("add at head:");
    	 linkedList.addAtHead(1);
    	 linkedList.printList();
    	 
    	 System.out.println("add at tail:");
    	 linkedList.addAtTail(3);
    	 linkedList.printList();
    	 
    	 System.out.println("add at index:");
    	 linkedList.addAtIndex(1, 2);
    	 linkedList.printList();
    	 
    	 System.out.println("get:");
    	 linkedList.get(1);
    	 linkedList.printList();
    	 
    	 System.out.println("delet at index:");
    	 linkedList.deleteAtIndex(1);
    	 linkedList.printList();
    	 
    	 System.out.println("get:");
    	 linkedList.get(1);
    	 linkedList.printList();
    	 
     }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */