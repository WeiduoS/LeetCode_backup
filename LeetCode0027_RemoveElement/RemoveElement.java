package LeetCode0027_RemoveElement;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        
        while(i <= j){
            if(nums[i] == val){
                nums[i] = nums[j];
                nums[j] = 0;
                j--;
            }else{
                i++;
            }
        }
        
        return j + 1;
    }
}