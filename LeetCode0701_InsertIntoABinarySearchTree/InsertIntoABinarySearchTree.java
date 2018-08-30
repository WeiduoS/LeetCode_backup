package LeetCode0701_InsertIntoABinarySearchTree;

public class InsertIntoABinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	// solution 1: iterative
    public TreeNode insertIntoBSTI(TreeNode root, int val) {
        TreeNode newTreeNode = new TreeNode(val);
        if(root == null) return newTreeNode;
        TreeNode newRoot = root;
        while(root != null) {
            if(root.val < val) {
                if(root.right == null) {
                    root.right = newTreeNode;
                    break;
                }else{
                    root = root.right;
                }
            }else if(root.val > val) {
                if(root.left == null) {
                    root.left = newTreeNode;
                    break;
                }else{
                    root = root.left;
                }
            }
        }
        return newRoot;
    }
    // solution 2: Recursive
    public TreeNode insertIntoBSTII(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val < val) {
            root.right = insertIntoBSTII(root.right, val);
        }else{
            root.left = insertIntoBSTII(root.left, val);
        }
        return root;
    }	
}