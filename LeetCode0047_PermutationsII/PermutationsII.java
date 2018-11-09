package LeetCode0047_PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	/*
    int len;
    public List<List<Integer>> permuteUnique(int[] nums) {
        len = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums) {
            countMap.compute(num, (key, val) -> {
                if(val == null) return 1;
                else return val + 1;
            });
        }
        int[] digits = new int[countMap.size()];
        int[] counts = new int[countMap.size()];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            digits[index] = entry.getKey();
            counts[index] = entry.getValue();
            index++;
        }
        //System.out.println(Arrays.toString(digits));
        //System.out.println(Arrays.toString(counts));
        List<List<Integer>> res = new ArrayList<>();
        permuteUtil(digits, counts, res, new ArrayList<>(), 0);
        return res;
    }
    
    private void permuteUtil(int[] digits, int[] counts, List<List<Integer>> res, List<Integer> temp, int level) {
        if(level == len) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < digits.length; i++) {
            if(counts[i] == 0) continue;
            temp.add(digits[i]);
            counts[i]--;
            permuteUtil(digits, counts, res, temp, level + 1);
            temp.remove(temp.size() - 1);
            counts[i]++;
        }
    }*/
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(list, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return list;
    }
    
    private void backtracking(List<List<Integer>> list, List<Integer> temp, int[] nums, boolean[] used) {
        if(temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i] == true || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            temp.add(nums[i]);
            backtracking(list, temp, nums, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
