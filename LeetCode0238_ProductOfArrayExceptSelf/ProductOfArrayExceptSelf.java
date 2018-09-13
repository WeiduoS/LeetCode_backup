package LeetCode0238_ProductOfArrayExceptSelf;

public class ProductOfArrayExceptSelf {
	/*
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int product = 0;
        int index = 0;
        int zeroNum = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                product = nums[i];
                index = i + 1;
                break;
            }else{
                zeroNum++;
            }
        }
        
        for(int i = index; i < n; i++) {
            if(nums[i] == 0) {
                zeroNum++;
                continue;
            }else {
                product *= nums[i]; 
            }
        }
        //System.out.println(zeroNum);
        for(int i = 0; i < n; i++) {
            if(zeroNum >= 2) {
                nums[i] = 0;
            }else{
                if(nums[i] == 0) {
                    res[i] = product;
                }else if(nums[i] != 0) {
                    if(zeroNum == 1) {
                        res[i] = 0;
                    }else{
                        res[i] = divide(product, nums[i]);
                    }
                }
            }
        }
        return res;
    }
    
    private int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 0) return 0;
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        
        long divid = Math.abs((long) dividend);
        long divis = Math.abs((long) divisor);
        
        int res = 0;
        
        while(divid >= divis) {
            int shift = 0;
            while(divid >= divis << shift) shift ++;
            
            res += 1 << shift - 1;
            divid -= divis << shift - 1;
        }
        
        return sign == 1 ? res : - res;
    }*/
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) return new int[0];
        int[] res = new int[n];
        res[0] = 1;
        // the cumulative product of left side
        for(int i = 1; i < n; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        //System.out.println(Arrays.toString(res));
        // the cumulative product of right side and total product
        int rightP = 1;
        for(int i = n - 1; i >= 0; i--) {
            res[i] = rightP * res[i];
            rightP *= nums[i];
        }
        return res;
    }	
}