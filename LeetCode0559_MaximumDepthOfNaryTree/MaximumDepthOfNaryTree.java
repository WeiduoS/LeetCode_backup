package LeetCode0559_MaximumDepthOfNaryTree;

import java.util.List;

public class MaximumDepthOfNaryTree {
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	public int maxDepth(Node root) {
		if(root == null) return 0;
		int dep = 0;
		for(Node node : root.children) {
			dep = Math.max(maxDepth(node), dep);
		}
	    return dep + 1;
	}	
}