package LeetCode0138_CopyListWithRandomPointer;


public class CopyListWithRandomPointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	}
	
	// HashMap Solution
    /*
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode node = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while(node != null){
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        
        node = head;
        while(node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
            
        }
        
        return map.get(head);
         
    }*/
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        
        RandomListNode curr = head;
        
        while(curr != null){
            RandomListNode copy = new RandomListNode(curr.label);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        curr = head;
        RandomListNode newHead = head.next;
        while(curr != null){
            RandomListNode currNext = curr.next;
            curr.next = currNext.next;
            if(currNext.next != null){
                currNext.next = currNext.next.next;
            }
            curr = curr.next;
        }
        
        return newHead;
        
    }
	
	
}