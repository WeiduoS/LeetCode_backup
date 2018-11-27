package LeetCode0360_SortTransformedArray;

public class SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int l = 0, r = nums.length - 1;
        int index = a >= 0 ? nums.length - 1 : 0;
        while(l <= r) {
            int left = compute(a, b, c, nums[l]);
            int right = compute(a, b, c, nums[r]);
            
            if(a >= 0) {
               if(left >= right) {
                   res[index--] = left;
                   l++;
               }else{
                   res[index--] = right;
                   r--;
               }
            }else{
               if(left <= right) {
                   res[index++] = left;
                   l++;
               }else{
                   res[index++] = right;
                   r--;
               }
            }
        }
        return res;
    }
    
    private int compute(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
}
