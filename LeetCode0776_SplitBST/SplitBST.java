package LeetCode0776_SplitBST;

public class SplitBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[]{null, null};
        if(root == null) return res;
        if(root.val <= V) {
            res = splitBST(root.right, V);
            root.right = res[0];
            res[0] = root;
        }else{
            res = splitBST(root.left, V);
            root.left = res[1];
            res[1] = root;
        }
        return res;
    }
}
