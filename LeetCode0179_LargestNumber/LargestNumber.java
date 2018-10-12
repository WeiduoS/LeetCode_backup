package LeetCode0179_LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	private class LargerNumberComparator implements Comparator<String> {
		@Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }
    
    public String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, new LargerNumberComparator());
        if(asStrs[0].equals("0")) return "0";
        
        String res = new String();
        for(String s : asStrs) res += s;
        return res;
    }	
}