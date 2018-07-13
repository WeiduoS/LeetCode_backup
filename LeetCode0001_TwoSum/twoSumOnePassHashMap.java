package LeetCode0001_TwoSum;

import java.util.HashMap;

public class twoSumOnePassHashMap {
	
	public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>(); 

        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if(map.containsKey(left) && map.get(left) != i){
                return new int[] {map.get(left), i};
            }   
        map.put(nums[i],i);
        }
        
        throw new IllegalArgumentException("No two sum solution");    
     
    }
	
	public static void main(String[] args) {
		int nums[] = {3,2,4};
		int target = 6;
		
		twoSumOnePassHashMap mytwoSum = new twoSumOnePassHashMap();
		
		int[] ans = mytwoSum.twoSum(nums, target);
		
		for(int num : ans) {
			System.out.printf("%d %d\n",num, nums[num]);
		}
	}
	
}