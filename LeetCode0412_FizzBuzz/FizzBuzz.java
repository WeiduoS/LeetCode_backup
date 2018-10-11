package LeetCode0412_FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        for(int i = 1; i <= n; i++) {
            String temp = "";
            if((i % 3 == 0 || i % 5 == 0) && i >= 3) {
                if(i % 3 == 0) temp += "Fizz";
                if(i % 5 == 0) temp += "Buzz";
            }else{
                temp += String.valueOf(i);
            }
            res.add(temp);
        }
        return res;
    }	
}