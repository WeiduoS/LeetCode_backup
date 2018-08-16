package LeetCode0155_MinStack;

import java.util.Stack;

public class MinStack {
	/*
	// solution 1
	private class Node {
        int val;
        int min;
        Node next;
        
        private Node(int val, int min) {
            this(val, min, null);
        }
        
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    } 
    
    private Node head;
    
    public MinStackI() {
        
    }
    
    public void pushI(int x) {
        if(head == null) {
            head = new Node(x, x);
        }else{
            head = new Node(x, Math.min(x, head.min), head);
        }
    }
    
    public void popI() {
        head = head.next;
    }
    
    public int topI() {
        return head.val;
    }
    
    public int getMinI() {
        return head.min;
    }*/
    /*
    // solution 2
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()) {
            minStack.push(x);
        }else{
            minStack.push(Math.min(x, minStack.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }*/
    // solution 3
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;
    
    public MinStack() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.pop() == min) min = stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}