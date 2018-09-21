package LeetCode0230_KthSmallestElementInABST;

public class KthSmallestElementInABST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        TreeNode cur = root;
        while(cur.left != null) cur = cur.left;
        while(k > 1) {
            cur = findSuccessor(root, cur);
            k--;
        }
        
        return cur.val;
    }
    private TreeNode findSuccessor(TreeNode root, TreeNode target) {
        TreeNode cur = root;
        TreeNode succ = null;
        while(cur != null) {
           if(cur.val <= target.val) {
                cur = cur.right;
            }else{
               succ = cur;
               cur = cur.left;
           } 
        }
        return succ;
    }	
}