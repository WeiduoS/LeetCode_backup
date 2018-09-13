package LeetCode0029_DivideTwoIntegers;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        
        int sign = ((dividend > 0) ^ (divisor > 0))? -1 : 1;
        long divid = Math.abs((long)dividend);
        long divs = Math.abs((long)divisor);
        
        int res = 0;
        
        while(divid >= divs) {
            int shift = 0;
            while(divid >= divs << shift) {
                shift++;
            }
            res += 1 << shift - 1;
            divid -= divs << shift - 1;
            
        }
        
        return sign == 1 ? res : -res;
    }	
}