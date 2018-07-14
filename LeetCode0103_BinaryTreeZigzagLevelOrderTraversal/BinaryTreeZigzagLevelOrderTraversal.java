package LeetCode0103_BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal{
	
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
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        stack.push(root);
        if(root == null) return list;
        
        boolean directionFlag = false;
        
        while(!stack.isEmpty()){
            Stack<TreeNode> tempStack=new Stack<>();
            List<Integer> subList = new ArrayList<Integer>();
            while(!stack.isEmpty()){
                root = stack.pop();
                subList.add(root.val);
                if(!directionFlag){
                    if(root.left != null){
                        tempStack.push(root.left);
                    }
                    if(root.right != null){
                        tempStack.push(root.right);
                    }
                }
                if(directionFlag){
                    if(root.right != null){
                        tempStack.push(root.right);
                    }
                    if(root.left != null){
                        tempStack.push(root.left);
                    }
                }
            }
        directionFlag = !directionFlag;
        stack = tempStack;
        list.add(subList);   
        }
     return list;   
    }
	
	
	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal bi=new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode rootNode=createBinaryTree();
		System.out.println("Sprial Level Binary Tree Traverse:"); 
		System.out.println(Arrays.toString(bi.zigzagLevelOrder(rootNode).toArray()));
	}
}