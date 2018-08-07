package LeetCode0202_HappyNumber;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public boolean isHappy(int n) {
        if(n == 0) return false;
        
        Set<Integer> set = new HashSet<>();
        
        while(set.add(n)){
            int sum = 0;
            while(n > 0){
                int digit = n % 10;
                sum = sum + digit * digit;
                n = n / 10;
            }
            if(sum == 1){
                return true;
            }else{
                n = sum;
            }
        }
        return false;
    }
}