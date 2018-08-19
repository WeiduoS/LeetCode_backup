package LeetCode0232_ImplementQueueUsingStacks;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	private int front;
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s1.isEmpty()) {
            front = x;
        }
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int temp = s1.pop();
        if(!s1.isEmpty()) front = s1.peek();
        return temp;
    }
    
    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }	
}