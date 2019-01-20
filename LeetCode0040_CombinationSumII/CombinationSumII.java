package LeetCode0040_CombinationSumII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class CombinationSumII {
	List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, 0, 0, target, new ArrayDeque<Integer>());
        return res;
    }
    
    private void backtracking(int[] candidates, int sum, int pos, int target, Deque<Integer> temp) {
        if(sum == target) {res.add(new ArrayList<>(temp)); return;}
        else if(sum > target) return;
        for(int i = pos; i < candidates.length; i++) {
            if(i > pos && candidates[i] == candidates[i - 1]) continue;
            temp.add(candidates[i]);
            backtracking(candidates, sum + candidates[i], i + 1, target, temp);
            temp.pollLast();
        }
    }
}
