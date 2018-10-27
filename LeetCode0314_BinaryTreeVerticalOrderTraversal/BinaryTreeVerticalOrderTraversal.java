package LeetCode0314_BinaryTreeVerticalOrderTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        Map<TreeNode, Integer> nodeMap = new HashMap<>();
        Map<Integer, ArrayList<Integer>> indexMap = new HashMap<>();
        nodeMap.put(root, 0);
        indexMap.put(nodeMap.get(root), new ArrayList<Integer>());
        indexMap.get(nodeMap.get(root)).add(root.val);
        
        TreeNode cur = null;
        int min = 0, max = 0;
        while(!queue.isEmpty()) {
            cur = queue.poll();
            //System.out.println(cur.val);
            //System.out.println("nodeMap.get(cur): " + nodeMap.get(cur));
            if(cur.left != null) {
                queue.offer(cur.left);
                int index = nodeMap.get(cur) - 1;
                nodeMap.put(cur.left, index);
                min = Math.min(min, index);
                if(indexMap.containsKey(index)) {
                    indexMap.get(index).add(cur.left.val);
                }else{
                    indexMap.put(nodeMap.get(cur.left), new ArrayList<Integer>());
                    indexMap.get(index).add(cur.left.val);
                }
            }
            if(cur.right != null) {
                queue.offer(cur.right);
                int index = nodeMap.get(cur) + 1;
                nodeMap.put(cur.right, index);
                max = Math.max(max, index);
                if(indexMap.containsKey(index)) {
                    indexMap.get(index).add(cur.right.val);
                }else{
                    indexMap.put(nodeMap.get(cur.right), new ArrayList<Integer>());
                    indexMap.get(index).add(cur.right.val);
                }
            }
        }
        
        for(int i = min; i <= max; i++) {
            res.add(indexMap.get(i));
        }
        
        return res;
    }	
}