package LeetCode0528_RandomPickWithWeight;

import java.util.Random;

public class RandomPickWithWeight {
	int[] sum;
    Random rand = new Random();
    public void Solution(int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        for(int i = 1; i < w.length; i++) {
            sum[i] = sum[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        int index = rand.nextInt(sum[sum.length - 1]);
        int l = 0, r = sum.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(sum[mid] <= index) l = mid + 1;
            else r = mid;
        }
        return r;
    }
}
