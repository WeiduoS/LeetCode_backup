package LeetCode0046_Permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Permutations {
	 public List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        if(nums == null || nums.length == 0) return res;
	        Map<Integer, Integer> countMap = new TreeMap<>();
	        for(int num : nums) {
	            countMap.compute(num, (key, value) -> value == null ? 1 : value + 1);

	        }
	        int[] digits = new int[countMap.size()];
	        int[] count = new int[countMap.size()];
	        int index = 0;
	        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
	            digits[index] = entry.getKey();
	            count[index] = entry.getValue();
	            index++;
	        }
	        dfs(digits, count, res, new ArrayList<>(), 0);
	        return res;
	    }
	    
	    private void dfs(int[] digits, int[] count, List<List<Integer>> res, List<Integer> temp, int level) {
	        if(level == digits.length) {
	            res.add(new ArrayList<>(temp));
	            return;
	        }
	        for(int i = 0; i < digits.length; i++) {
	            if(count[i] == 0) continue;
	            temp.add(digits[i]);
	            count[i]--;
	            dfs(digits, count, res, temp, level + 1);
	            temp.remove(temp.size() - 1);
	            count[i]++;
	        }
	    }
}