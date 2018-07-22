package LeetCode0113_PathSumII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PathSumII{
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
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new LinkedList<>();
        if(root == null) return list;
        pathSumExtend(root, sum, list, new LinkedList<>());
        return list;
    }
    private void pathSumExtend(TreeNode root, int sum, List<List<Integer>> list, LinkedList<Integer> subList){
        if(root == null) return;
        if(root != null && root.left == null && root.right == null){
            if(sum == root.val){
                subList.add(root.val);
                list.add(new LinkedList<Integer>(subList));
                subList.remove(subList.size() - 1);
            }
            return;
        }
        subList.add(root.val);
        pathSumExtend(root.left, sum - root.val, list, subList);
        pathSumExtend(root.right, sum - root.val, list, subList);
        subList.remove(subList.size() - 1);
        return;
    }
	
	
	public static void main(String[] args) {
		// Creating a binary tree
		PathSumII bi = new PathSumII();
		TreeNode rootNode=createBinaryTree();
		List<List<Integer>> res = bi.pathSum(rootNode, 70);
		System.out.println(Arrays.toString(res.toArray())); 
	}
}