package LeetCode0107_BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversalII{
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
	// Top down sequence
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
                subList.add(root.val);              
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
	// Bottom Up sequence BFS
	public List<List<Integer>> levelOrderII(TreeNode root) {
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
                subList.add(root.val);              
                if (root.left != null) {
                    queue.add(root.left);        
                }
                if (root.right != null) {
                    queue.add(root.right);       
                }
            }
            list.add(0, subList);   
        } 
       return list;
    }
	// Bottom up sequence DFS
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        levelOrderBottomExtend(list, root, 0);
        return list;
    }
    private void levelOrderBottomExtend(List<List<Integer>> list, TreeNode root, int level){
        if(root == null) return;
        if(level >= list.size()){
            list.add(0, new LinkedList<Integer>());
        }
        levelOrderBottomExtend(list, root.left, level + 1);
        levelOrderBottomExtend(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
        
    }
	
	
	public static void main(String[] args) {
		// Creating a binary tree
		BinaryTreeLevelOrderTraversalII bi = new BinaryTreeLevelOrderTraversalII();
		TreeNode rootNode=createBinaryTree();
		System.out.println("Top Down Level Order traversal of binary tree will be:");
		List<List<Integer>> list1 = bi.levelOrder(rootNode);
		System.out.println(Arrays.toString(list1.toArray()));
		System.out.println("");
		System.out.println("Bottom Up(BFS) Level Order traversal of binary tree will be:");
		List<List<Integer>> list2 = bi.levelOrderII(rootNode);
		System.out.println(Arrays.toString(list2.toArray()));
		System.out.println("");
		System.out.println("Bottom Up(DFS) Level Order traversal of binary tree will be:");
		List<List<Integer>> list3 = bi.levelOrderBottom(rootNode);
		System.out.println(Arrays.toString(list3.toArray()));
	}
}