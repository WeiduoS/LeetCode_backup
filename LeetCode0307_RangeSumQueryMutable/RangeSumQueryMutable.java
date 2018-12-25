package LeetCode0307_RangeSumQueryMutable;

public class RangeSumQueryMutable {
	int[] sum;
    int[] nums;
    public void NumArray(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            updateTree(i, nums[i]);
        }
    }
    
    public void updateTree(int i, int val) {
        i = i + 1;
        while(i < sum.length){
        	sum[i] += val;
        	i += i & (-i); // the last set bit/ Two's complement
        }
    }
    
    public void update(int i, int val) {
        updateTree(i, val - nums[i]);
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        j = j + 1;
        int sum1 = 0, sum2 = 0;
    	while(i > 0){
    		sum1 += sum[i];
    		i -= i & (-i);// Another tree, go to the ancestor
    	}
        while(j > 0) {
            sum2 += sum[j];
            j -= j & (-j);
        }
        return sum2 - sum1;
    }
}
