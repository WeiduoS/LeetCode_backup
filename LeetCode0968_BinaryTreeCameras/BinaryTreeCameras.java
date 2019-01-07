package LeetCode0968_BinaryTreeCameras;

public class BinaryTreeCameras {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	int res;
    public int minCameraCover(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        res = 0;
        int state = helper(root);
        if(state == 0) res++;
        return res;
    }

    private int helper(TreeNode root){
        if(root == null) return 2;
        //if(root.left == null && root.right == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        //System.out.println("root.val: " + root.val + ", left: " + left + ", right: " + right + ", res: " + res);
        if(left == 0 || right == 0) {
            res++;
            return 1;
        }
        if(left == 1 || right == 1) return 2;
        return 0;
    }
}
