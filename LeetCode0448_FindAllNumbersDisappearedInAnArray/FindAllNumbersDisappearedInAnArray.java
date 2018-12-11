package LeetCode0448_FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int pos = Math.abs(nums[i]) - 1;
            if(pos == -1) pos = nums.length - 1;
            if(nums[pos] < 0) continue;
            else nums[pos] = -nums[pos];
            //System.out.println(Arrays.toString(nums));
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) res.add(i + 1);
        }
        return res;
    }
}
