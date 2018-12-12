package LeetCode060_PermutationSequence;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
public String getPermutation(int n, int k) {
        
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) list.add(i);
        
        int[] factorial = new int[n];
        factorial[0] = 1;
        for(int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        //System.out.println(Arrays.toString(factorial));
        k--;
        char[] res = new char[n];
        for(int i = 0; i < n; i++) {
            res[i] = Character.forDigit(list.remove(k / factorial[n - 1 - i]), 10);
            k = k % factorial[n - 1 - i];
        }
        
        return new String(res);
    }
}
