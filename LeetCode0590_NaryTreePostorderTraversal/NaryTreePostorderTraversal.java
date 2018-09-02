package LeetCode0590_NaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        return postorderExtend(root, list);
    }
    private List<Integer> postorderExtend(Node root, List<Integer> list) {
        if(root != null) {
            for(Node node : root.children) postorderExtend(node, list);
        }
        list.add(root.val);
        return list;
    }	
}