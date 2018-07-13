package LeetCode0002_AddTwoNumber;

import java.util.LinkedList;

public class AddTwoNumbers{

	public LinkedList<Integer> addTwoNumbers(LinkedList<Integer> L1, LinkedList<Integer> L2) {
		LinkedList<Integer> ans = new LinkedList<Integer>();
		int carry = 0;
		//LinkedList<Integer> p1 = (LinkedList<Integer>) L1.clone();
		//LinkedList<Integer> p2 = (LinkedList<Integer>) L2.clone();
		
		while(L1.listIterator().hasNext() || L2.listIterator().hasNext()) {
			int x = L1.listIterator().hasNext()? L1.listIterator().next() : null;
			int y = L2.listIterator().hasNext()? L2.listIterator().next() : null;
			int sum = x + y + carry;
			carry = (int) Math.floor(sum / 10);
			ans.add(sum % 10);
			L1.remove();
			L2.remove();
		}	
		return ans;
	}

	
	/**
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: 7 -> 0 -> 8
    */
	public static void main (String[] args){
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.clear();
		l1.add(2);
		l1.add(4);
		l1.add(3);
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.clear();
		l2.add(5);
		l2.add(6);
		l2.add(4);
		
		AddTwoNumbers res = new AddTwoNumbers();
		LinkedList<Integer> result = res.addTwoNumbers(l1, l2);
		LinkedList<Integer> temp = (LinkedList<Integer>) result.clone();
		LinkedList<Integer> reverse = new LinkedList<Integer>();

		while(temp.getLast() != null && temp.getLast() != temp.getFirst()) {
			reverse.add(temp.getLast());
			temp.removeLast();
		}
		reverse.add(temp.getFirst());
		
		System.out.println("Linked list 1st: " + l1);
		System.out.println("Linked list 2nd: " + l2);
		System.out.println("reverse version:" + result);	
	    System.out.println("normal version:"+ reverse);
		
	}
}