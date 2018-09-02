package LeetCode0589_NaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal {
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	// solution 1: iterative
   
    public List<Integer> preorderI(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for(int i = root.children.size() - 1; i >= 0; i--) {
                stack.add(root.children.get(i));
            }
        }
        return list;
    }
    // solution 2: recursive
    public List<Integer> preorderII(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        return preorderExtend(root, list);
    }
    private List<Integer> preorderExtend(Node root, List<Integer> list) {
        if(root != null) list.add(root.val);
        for(Node node : root.children) preorderExtend(node, list);
        return list;
    }	
}