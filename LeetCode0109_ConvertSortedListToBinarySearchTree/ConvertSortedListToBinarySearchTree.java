package LeetCode0109_ConvertSortedListToBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        return helper(list, 0, list.size() - 1);
    }
    
    private TreeNode helper(List<Integer> list, int l, int r) {
        if(l > r) return null;
        int m = l + (r - l) / 2;
        TreeNode node = new TreeNode(list.get(m));
        node.left = helper(list, l, m - 1);
        node.right = helper(list, m + 1, r);
        return node;
    }
}
