package LeetCode0872_LeafSimilarTrees;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        helper(root1, l1);
        helper(root2, l2);
        return l1.equals(l2);
    }
    
    private void helper(TreeNode root, List<Integer> list) {
        if(root == null) return;
        if(root.left == null && root.right == null) list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }
}
