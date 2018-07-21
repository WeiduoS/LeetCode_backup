package LeetCode0297_SerializeAndDeserializeBinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class SerializeAndDeserializeBinaryTreeIterDFS{
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
	 * 			   1
	 *            / \
	 *           2   3
	 *              / \
	 *             4   5
	 */
	public static TreeNode createBinaryTree() {
		TreeNode rootNode = new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);

		
		rootNode.left = node2;
		rootNode.right = node3;
		
		node3.left=node4;
		node3.right=node5;
 
		return rootNode;
			
	}
	
	//Encodes a tree to a single string.
	public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack =new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while(root != null ){
                stack.push(root);
                sb.append(String.valueOf(root.val));
                sb.append(" ");
                root = root.left;
            }
            sb.append("null ");
            root = stack.pop();
            root = root.right;
        }
        return sb.toString();
    }
	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data == null) return null;
		String[] str = data.split(" ");
		Stack<TreeNode> stack = new Stack<>();
		TreeNode root = new TreeNode(Integer.valueOf(str[0]));
		stack.push(root);
		TreeNode node = root;
		int strIndex;
		for(strIndex = 1; strIndex < str.length - 1;) {
			//System.out.println("loop1 - strIndex:" + strIndex + ", str[strIndex]: "+ str[strIndex]);
			if(!str[strIndex].equals("null")) {
				//System.out.println("loop2 - strIndex:" + strIndex + ", node.val:" + node.val);
				node.left = new TreeNode(Integer.valueOf(str[strIndex]));
				node = node.left;
				stack.push(node);
				strIndex++;
			}else {
				node = stack.pop();
				strIndex++;
				//System.out.println("node.val: " + node.val + ", loop3 - strIndex:" + strIndex);
				if(!str[strIndex].equals("null")) {
					//System.out.println(node.val);
					node.right = new TreeNode(Integer.valueOf(str[strIndex]));
					node = node.right;
					stack.push(node);
					strIndex++;
				}
			}
			
		}
		return root;
	}

    public String treeNodeToString(TreeNode root) {
		if(root == null) {
			return "[ ]";
		}
		String output = "";
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		
		while(!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();
			
			if(node == null) {
				output += "null, ";
				continue;
			}
			
			output += String.valueOf(node.val) + ", ";
			nodeQueue.add(node.left);
			nodeQueue.add(node.right);
		}
		return "[" + output.substring(0, output.length() - 2) + "]";
		
	}
	
	public static void main(String[] args) {
		SerializeAndDeserializeBinaryTreeIterDFS bi=new SerializeAndDeserializeBinaryTreeIterDFS();
		TreeNode rootNode = createBinaryTree();
		System.out.println("Encodes a tree to a single string:"); 
		System.out.println(bi.serialize(rootNode)); 
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("Decodes your encoded data to tree:");
		System.out.println(bi.treeNodeToString(bi.deserialize(bi.serialize(rootNode)))); 

	}
}