package LeetCode0315_CountOfSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfSmallerNumbersAfterSelf {
	/*
    class TreeNode {
        int leftCount;
        int val;
        int dup;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int v) {
            left = null;
            right = null;
            this.val = v;
            this.dup = 1;
        }
    }
    private int insert(TreeNode root, int num) {
        if(root.val == num) {
            root.dup++;
            return root.leftCount;
        }else if(root.val > num) {
            root.leftCount++;
            if(root.left == null) {
                root.left = new TreeNode(num);
                return 0;
            }
            return insert(root.left, num);
        }else {
            if(root.right == null) {
                root.right = new TreeNode(num);
                return root.leftCount + root.dup;
            }
            return root.leftCount + root.dup + insert(root.right, num);
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        if(nums == null || nums.length == 0) return Arrays.asList(ans);
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        ans[nums.length - 1] = 0;
        
        for(int i = nums.length - 2; i >= 0; i--) {
            ans[i] = insert(root, nums[i]);
        }
        
        return Arrays.asList(ans);
    }*/
    
    class IndexBinaryTree{
        int[] sums;
        IndexBinaryTree(int n) {
            this.sums = new int[n + 1];
        }
        void update(int i, int delta) {
            while(i < sums.length) {
                sums[i] += delta;
                i += lowBit(i);
            }
        }
        int query(int i) {
            int sum = 0;
            while(i > 0) {
                sum += sums[i];
                i -= lowBit(i);
            }
            return sum;
        }
        int lowBit(int i) {
            return (i & (-i));
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int[] sortedArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedArr);
        Map<Integer, Integer> map = new HashMap<>();
        int ranks = 0;
        for(int i = 0; i < sortedArr.length; i++) {
            if(i == 0 || sortedArr[i] != sortedArr[i  - 1]){
                map.put(sortedArr[i], ++ranks);
            }
        }
        /*
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }*/
        IndexBinaryTree tree = new IndexBinaryTree(nums.length + 1);
        List<Integer> res = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            res.add(tree.query(map.get(nums[i]) - 1));
            tree.update(map.get(nums[i]), 1);
        }
        Collections.reverse(res);
        return res;
    }	
}