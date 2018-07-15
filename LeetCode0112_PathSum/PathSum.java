package LeetCode0112_PathSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


public class PathSum{
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int data){
			this.val = data;
		}
	}
	
	// Create Binary Tree
	/*
	 * 			   40
	 *           /    \
	 *        20        60
	 *       /  \      /  \
	 *      10  30    50   70
	 */
	public static TreeNode createBinaryTree() {
		TreeNode rootNode = new TreeNode(40);
		TreeNode node20=new TreeNode(20);
		TreeNode node10=new TreeNode(10);
		TreeNode node30=new TreeNode(30);
		TreeNode node60=new TreeNode(60);
		TreeNode node50=new TreeNode(50);
		TreeNode node70=new TreeNode(70);
		
		rootNode.left = node20;
		rootNode.right = node60;
		
		node20.left=node10;
		node20.right=node30;
 
		node60.left=node50;
		node60.right=node70;
 
		return rootNode;
			
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root != null && root.left == null && root.right == null) return sum == root.val;
        return hasPathSumExtend(root.left, root.val, sum) || hasPathSumExtend(root.right, root.val, sum);
    }
    private boolean hasPathSumExtend(TreeNode root, int pathSum, int sum){
        if(root == null) return false;
        pathSum = root.val + pathSum;
        //System.out.println(pathSum);
        if(root.left == null && root.right == null) {
            if(sum == pathSum){
                return true;
            }else{
                return false;
            }
        }
        return hasPathSumExtend(root.left, pathSum, sum) || hasPathSumExtend(root.right, pathSum, sum);
    }
	
	
	public static void main(String[] args) {
		// Creating a binary tree
		PathSum bi = new PathSum();
		TreeNode rootNode=createBinaryTree();
		boolean res = bi.hasPathSum(rootNode, 70);
		System.out.println(res);
	}
}