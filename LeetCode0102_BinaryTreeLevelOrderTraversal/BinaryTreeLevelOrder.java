package LeetCode0102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeLevelOrder{
	public static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode (int data){
			this.data = data;
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
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root != null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            List<Integer> subList = new LinkedList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {       
                root = queue.poll();
                subList.add(root.data);              
                if (root.left != null) {
                    queue.add(root.left);        
                }
                if (root.right != null) {
                    queue.add(root.right);       
                }
            }
            list.add(subList);   
        } 
       return list;
    }
	
	
	public static void main(String[] args) {
		// Creating a binary tree
		BinaryTreeLevelOrder bi = new BinaryTreeLevelOrder();
		TreeNode rootNode=createBinaryTree();
		System.out.println("Level Order traversal of binary tree will be:");
		List<List<Integer>> list = bi.levelOrder(rootNode);
		System.out.println(Arrays.toString(list.toArray()));
	}
}