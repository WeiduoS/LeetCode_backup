package LeetCode0163_MissingRanges;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        if(nums == null || n == 0) {
            res.add(range(lower, upper));
            return res;
        }
        String beforeP = range((long)lower, (long)nums[0] - 1);
        if(!beforeP.equals("")) res.add(beforeP);
        for(int i = 0, j = 1; j < nums.length; j++) {
            String temp = range((long)nums[i] + 1, (long)nums[j] - 1);
            if(!temp.equals("")) res.add(temp);
            i++;
        }
        String afterP = range((long)nums[n - 1] + 1, (long)upper);
        if(!afterP.equals("")) res.add(afterP);
        return res;
    }
    
    private String range(long start, long end) {
        //System.out.println("start: " + start + ", end: " + end);
        if(start > end){
            return "";
        }else if(start == end) {
            return String.valueOf(start);
        }else{
            return start + "->" + end ;
        }
        
    }	
}