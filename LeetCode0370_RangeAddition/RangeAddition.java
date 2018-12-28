package LeetCode0370_RangeAddition;

public class RangeAddition {
	public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        int[] nums = new int[length + 1];
        
        for(int[] update : updates) {
            nums[update[0]] += update[2];
            nums[update[1] + 1] -= update[2];
        }
        
        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }
}
