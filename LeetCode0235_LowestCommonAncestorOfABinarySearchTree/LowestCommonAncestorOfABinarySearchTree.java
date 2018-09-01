package LeetCode0235_LowestCommonAncestorOfABinarySearchTree;

public class LowestCommonAncestorOfABinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while(root != null) {
            if(root.val >= p.val && root.val <= q.val) {
                return root;
            }else if (root.val < p.val){
                root = root.right;
            }else if(root.val > q.val) {
                root = root.left;
            }
        }
        return root;
    }	
}