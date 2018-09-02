package LeetCode0429_NaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	    // solution 1: recursive
	    public List<List<Integer>> levelOrderI(Node root) {
	        List<List<Integer>> res = new ArrayList<>();
	        levelOrderExtend(root, res, 0);
	        return res;
	    }
	    private void levelOrderExtend(Node root, List<List<Integer>> res, int dep) {
	        if(root != null){
	            if(dep == res.size()){
	                res.add(new ArrayList<Integer>());
	            }
	            res.get(dep).add(root.val);
	            if(root.children != null) {
	                for(Node node : root.children) levelOrderExtend(node, res, dep + 1);
	            }
	        }
	    }
	    
	    // solution 2: iterative
	    
	    public List<List<Integer>> levelOrderII(Node root) {
	        List<List<Integer>> list = new ArrayList<>();
	        if(root == null) return list;
	        Queue<Node> queue = new LinkedList<>();
	        queue.offer(root);
	        while(!queue.isEmpty()) {
	            List<Integer> subList = new ArrayList<>();
	            int len = queue.size();
	            for(int i = 0; i < len; i++) {
	                Node curr = queue.poll();
	                subList.add(curr.val);
	                for(Node node : curr.children) queue.add(node);
	            }
	            list.add(subList);
	        }
	        return list;
	    }
}