package LeetCode0863_AllNodesDistanceKInBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        DFS(root, target, res, K);
        return res;
    }
    
    private int DFS(TreeNode node, TreeNode target, List<Integer> res, int K) {
        if(node == null) {
            return -1;
        }else if(node.val == target.val) {
            DFSextend(node, res, K);
            return 1;
        }else{
            int left = DFS(node.left, target, res, K);
            int right = DFS(node.right, target, res, K);
            if(left != -1) {
                if(left == K) res.add(node.val);
                DFSextend(node.right, res, K - left - 1);
                return left + 1;
            }else if(right != -1) {
                if(right == K) res.add(node.val);
                DFSextend(node.left, res, K - right - 1);
                return right + 1;
            }
            return -1;
        }
    }
    private void DFSextend(TreeNode node, List<Integer> res, int K) {
        if(node == null) return;
        //System.out.println("node.val: " + node.val + ", K: " + K);
        if(K == 0) {
            res.add(node.val);
            return;
        }else{
            DFSextend(node.left, res, K - 1);
            DFSextend(node.right, res, K - 1);
        }
    }	
}