package LeetCode0229_MajorityElementII;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int e1 = 0, e2 = 0;
        int c1 = 0, c2 = 0;
        
        for(int num : nums) {
            if(num == e1) {
                c1++;
            }else if(num == e2) {
                c2++;
            }else if(c1 == 0) {
                e1 = num;
                c1++;
            }else if(c2 == 0) {
                e2 = num;
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        
        c1 = 0;
        c2 = 0;
        
        for(int num : nums) {
            if(num == e1) c1++;
            else if(num == e2) c2++;
        }
        
        int len = nums.length;
        if(c1 > len / 3) res.add(e1);
        if(c2 > len / 3) res.add(e2);
        
        return res;
    }
}
