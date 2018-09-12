package LeetCode0015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	/*
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                if(nums[i] + nums[start] + nums[end] == 0 && start != end) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    res.add(temp);
                    while(i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
                    while(start + 1 < nums.length && nums[start + 1] == nums[start]) start++;
                    start++;
                    while(end - 1 >= 0 && nums[end - 1] == nums[end]) end--;
                    end--;
                }else if (nums[i] + nums[start] + nums[end] < 0){
                    while(start + 1 < nums.length && nums[start + 1] == nums[start]) start++;
                    start++;
                }else if(nums[i]+ nums[start] + nums[end] > 0) {
                    while(end - 1 >= 0 && nums[end - 1] == nums[end]) end--;
                    end--;
                }
            }
        }
        return res;
    }*/
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null && nums.length < 3) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            helper(-nums[i], nums, i + 1, res);
        }
        return res;
    }
    
    private void helper(int target, int[]nums, int i, List<List<Integer>> res) {
        int j = nums.length - 1;
        while(i < j) {
            if(nums[i] + nums[j] == target) {
                res.add(Arrays.asList(nums[i], nums[j], -target));
                i++;
                j--;
                while(i < j && nums[i] == nums[i - 1]) i++;
                while(i < j && nums[j] == nums[j + 1]) j--;
            }else if(nums[i] + nums[j] < target){
                i++;
            }else if(nums[i] + nums[j] > target) {
                j--;
            }
        }
    }	
}