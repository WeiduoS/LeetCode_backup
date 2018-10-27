package LeetCode0039_CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backTracking(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }
    
    private void backTracking(int[] candidates, int target, int pos, int pathSum, List<Integer> temp) {
        if(pathSum > target) return;
        if(pathSum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = pos; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backTracking(candidates, target, i, pathSum + candidates[i], temp);
            temp.remove(temp.size() - 1);
        }
    }	
}