package LeetCode0724_FindPivotIndex;

public class FindPivotIndex {
	public int pivotIndex(int[] nums) {
        int sum = 0, sumLeft = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
        }
        //System.out.println(sum);
        for(int i = 0; i < nums.length; i++){
            if(sum - nums[i] == sumLeft * 2){
                return i;
            }
            sumLeft = sumLeft + nums[i];
        }
        
        return -1;
    }
}