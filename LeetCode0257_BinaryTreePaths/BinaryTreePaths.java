package LeetCode0257_BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        return helper(root, res, "");
    }
    
    private List<String> helper(TreeNode root, List<String> res, String temp) {
        if(root.left == null && root.right == null) {
            temp += root.val;
            res.add(temp);
            //temp = temp.substring(0, temp.length() - 1);
        }else{
            temp = temp + root.val + "->";
            if(root.left != null) helper(root.left, res, temp);
            if(root.right != null) helper(root.right, res, temp);
            //temp = temp.substring(0, temp.length() - 3);
        }
        return res;
    }
    /*
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, res, "");
        return res;
    }
    
    private void helper(TreeNode root, List<String> res, String temp) {
        if(root.left == null && root.right == null) res.add(temp + root.val);
        if(root.left != null) helper(root.left, res, temp + root.val + "->");
        if(root.right != null) helper(root.right, res, temp + root.val + "->"); 
        return;  
    }*/
}
