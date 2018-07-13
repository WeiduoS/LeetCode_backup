package LeetCode0001_TwoSum;

import java.util.HashMap;

public class twoSumTwoPassHashMap {
	
	 public int[] twoSum(int[] nums, int target) {
	        
	        HashMap<Integer, Integer> map = new HashMap<>(); 
	        
	        for(int i = 0; i < nums.length; i++){
	            map.put(nums[i], i);
	        }
	        
	        for (int i = 0; i < nums.length; i++) {
	            int left = target - nums[i];
	            if(map.containsKey(left) && map.get(left) != i){
	                return new int[] {i, map.get(left)};
	            }
	        }
	        throw new IllegalArgumentException("No two sum solution");
	        
	    }
	 
	public static void main( String args[])
	{
		int nums[] = {2, 7, 11, 15};
		int target = 9;
		
		twoSumTwoPassHashMap mytwoSum = new twoSumTwoPassHashMap();
		
		int[] ans = mytwoSum.twoSum(nums, target);
		
		for(int num : ans) {
			System.out.printf("%d %d\n",num, nums[num]);
		}
	}
	
}


