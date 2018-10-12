package LeetCode0268_MissingNumber;

public class MissingNumber {
	public int missingNumber(int[] nums) {
        int originalSum = ((0 + nums.length) * (nums.length + 1)) / 2;
        int sum = 0;
        for(int num : nums) sum += num;
        return originalSum - sum;
    }
}