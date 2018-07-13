package LeetCode0001_TwoSum;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for ( int j = i + 1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if (sum == target){
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

public class twoSumBruteForce
{
	
	public static void main( String args[])
	{
		int nums[] = {2, 7, 11, 15};
		int target = 9;
		
		Solution mytwoSum = new Solution();
		
		int[] ans = mytwoSum.twoSum(nums, target);
		
		for(int num : ans) {
			System.out.printf("%d %d\n",num, nums[num]);
		}
	}
}