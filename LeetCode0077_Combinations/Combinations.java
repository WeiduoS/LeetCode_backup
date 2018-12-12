package LeetCode0077_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	List<List<Integer>> list;
    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();
        int[] nums = new int[n];
        for(int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        helper(nums, new ArrayList<Integer>(), k, 0);
        return list;
    }
    
    private void helper(int[] nums, List<Integer> subList, int k, int pos) {
        //System.out.println("k : " + k + ", subList: " + subList +", pos: " + pos);
        if(k == 0) {
            list.add(new ArrayList(subList));
            return;
        }
        
        for(int i = pos; i < nums.length; i++) {
            subList.add(nums[i]);
            helper(nums, subList, k - 1, i + 1);
            subList.remove(subList.size() - 1);
        }
    }
}
