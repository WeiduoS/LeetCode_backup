package LeetCode0653_TwoSumIV;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIV {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while(l < r) {
            int sum = list.get(l) + list.get(r);
            if(sum == k) {
                return true;
            }else if(sum < k) {
                l++;
            }else{
               r--; 
            }
        }
        return false;
    }
    private void inorder(TreeNode root, List<Integer> list) {
        if(root.left != null) inorder(root.left, list);
        list.add(root.val);
        if(root.right != null) inorder(root.right, list);
    }	
}