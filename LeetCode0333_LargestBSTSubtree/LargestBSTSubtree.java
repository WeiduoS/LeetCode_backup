package LeetCode0333_LargestBSTSubtree;

public class LargestBSTSubtree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	/*
    class MinMax{
        int min;
        int max;
        boolean isBST;
        int size;
        MinMax() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isBST = true;
            size = 0;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        MinMax m = isValidBST(root);
        return m.size;
    }
    
    private MinMax isValidBST(TreeNode root) {
        if(root == null) return new MinMax();
        MinMax left = isValidBST(root.left);
        MinMax right = isValidBST(root.right);
        
        MinMax m = new MinMax();
        
        if(left.isBST == false || right.isBST == false || left.max >= root.val || right.min <= root.val) {
            m.isBST = false;
            m.size = Math.max(left.size, right.size);
            return m;
        }
        
        m.isBST = true;
        m.size = left.size + right.size + 1;
        m.min = root.left == null ? root.val : left.min;
        m.max = root.right == null ? root.val : right.max;
        return m;
    }*/
    /*
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        if(isValidBST(root, null, null)) return largestBSTSubtree(root.left) + largestBSTSubtree(root.right) + 1;
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if(min != null && min >= root.val) return false;
        if(max != null && max <= root.val) return false;
        if(isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max)) return true;
        return false;
    }*/
    
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (isValid(root, null, null)) return countNode(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && min >= root.val) return false;
        if (max != null && max <= root.val) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    public int countNode(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + countNode(root.left) + countNode(root.right);
    }
}
