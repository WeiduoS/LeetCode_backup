package LeetCode0001_TwoSum;

public class twoSumArrayStore {
	
	    public int[] twoSum(int[] nums, int target) {
	        int[] map = new int [20050];
	        int diff, index, size = 4; 
	        for (int i = 0; i < nums.length ; i++) {
	            map[nums[i] + size] = i + 1;
	            //System.out.printf("%d\n", map[nums[i] + size]);
	            diff = target - nums [i + 1] + size;
	            if (diff < 0) continue; 
	            index = map[diff];
	            if (index > 0) 
	                return new int[] {index-1, i+1};
	        }
	        throw new IllegalArgumentException("No two sum solution");
	    }
	
	public static void main(String[] args) {
		int nums[] = {3,2,4};
		int target = 6;
		
		twoSumArrayStore mytwoSum = new twoSumArrayStore();
		
		int[] ans = mytwoSum.twoSum(nums, target);
		
		for(int num : ans) {
			System.out.printf("%d %d\n",num, nums[num]);
		}
	}
}