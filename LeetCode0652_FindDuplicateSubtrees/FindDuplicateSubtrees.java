package LeetCode0652_FindDuplicateSubtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    // solution 1:  Depth-First Search
    public List<TreeNode> findDuplicateSubtreesI (TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        helper(root, map, res);
        return res;
    }
    private static String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if(root == null) return "#";
        String serial = root.val + "," + helper(root.left, map, res) + "," + helper(root.right, map, res);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if(map.get(serial) == 2) res.add(root);
        return serial;
    }
    
    // solution 2:  Unique Identifier
    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> ans;
    
    public List<TreeNode> findDuplicateSubtreesII (TreeNode root) {
        t = 1;
        trees = new HashMap();
        count = new HashMap();
        ans = new ArrayList();
        lookup(root);
        return ans;
    }
    
    public int lookup(TreeNode node) {
        if(node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        int uid = trees.computeIfAbsent(serial, x-> t++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if(count.get(uid) == 2) ans.add(node);
        return uid;
    }
}