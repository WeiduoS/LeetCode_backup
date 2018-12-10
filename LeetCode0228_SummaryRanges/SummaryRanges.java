package LeetCode0228_SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int l = -1, r = -1;
        while(i < nums.length) {
            l = nums[i];
            while(i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            r = nums[i];
            String temp = "";
            if(l != r) {
                temp = String.valueOf(l) + "->" + String.valueOf(r);
            }else{
                temp = String.valueOf(l);
            }
            list.add(temp);
            i++;
        }
        return list;
    }
}
