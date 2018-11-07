package LeetCode0095_UniqueBinarySearchTreesII;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return helper(1, n);
    }
    
    private LinkedList<TreeNode> helper(int start, int end) {
        LinkedList<TreeNode> tree = new LinkedList<TreeNode>();
        
        if(start > end) {
            tree.add(null);
            return tree;
        }
        
        for(int i = start; i <= end; i++) {
            LinkedList<TreeNode> left_trees = helper(start, i - 1);
            LinkedList<TreeNode> right_trees = helper(i + 1, end);
            
            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    tree.add(current_tree);
                }
            }
        }
        
        return tree;
    }
}
