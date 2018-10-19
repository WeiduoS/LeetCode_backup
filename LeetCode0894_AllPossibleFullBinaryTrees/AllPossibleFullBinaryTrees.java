package LeetCode0894_AllPossibleFullBinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees {
	
	public class TreeNode {
		int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	Map<Integer, List<TreeNode>> map = new HashMap<>();
    
    public List<TreeNode> allPossibleFBT(int N) {
        if(map.containsKey(N)) return map.get(N);
        List<TreeNode> temp = new ArrayList<>();
        
        if(N % 2 == 0) return temp;
        
        if(N == 1) {
            temp.add(new TreeNode(0));
        }else if(N % 2 == 1) {
            for(int i = 1; i < N; i += 2) {
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(N - 1 - i);
                for(TreeNode l : left) {
                    for(TreeNode r : right) {
                        TreeNode node = new TreeNode(0);
                        node.left = l;
                        node.right = r;
                        temp.add(node);
                    }
                }
            }
        }
        map.put(N, temp);
        
        return map.get(N);
    }
}