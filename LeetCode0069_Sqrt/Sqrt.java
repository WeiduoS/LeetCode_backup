package LeetCode0069_Sqrt;

public class Sqrt {
	public int mySqrt(int x) {
        if(x == 0) return x;
        int left = 1;
        int right = x;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if(middle > x / middle) {
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        } 
        return right;
    }
}