package LeetCode0285_InorderSuccessorInBST;

public class InorderSuccessorInBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	// solution 1: iterativeI
    public TreeNode inorderSuccessorI(TreeNode root, TreeNode p) {
        TreeNode res = null;
        if(root.val == p.val) return res;
        while(root != null) {
            if(p.val < root.val) {
                res = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return res;
    }
    // solution 2: iterativeII
    public TreeNode inorderSuccessorII(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while(root != null) {
            if(root.val <= p.val) {
                root = root.right;
            }else{
                res = root;
                root = root.left;
            }
        }
        return res;
    }
    // solution 2: recursive
    public TreeNode inorderSuccessorIII(TreeNode root, TreeNode p) {
        if(root == null) return null;
        if(root.val <= p.val){
            return inorderSuccessor(root.right, p);
        }else{
            TreeNode succ = inorderSuccessor(root.left, p);
            return (succ != null) ? succ : root;
        } 
    }	
}