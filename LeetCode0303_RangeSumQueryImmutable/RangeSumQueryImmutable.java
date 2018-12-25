package LeetCode0303_RangeSumQueryImmutable;

public class RangeSumQueryImmutable {
	int[] sum;
    public void NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
        //System.out.println(Arrays.toString(sum));
    }
    
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
