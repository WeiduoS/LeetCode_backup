package LeetCode0881_BoatsToSavePeople;

import java.util.Arrays;

public class BoatsToSavePeople {
	public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1, res = 0;
        while(r >= 0 && people[r] >= limit) {
            res++;
            r--;
        }
        while(l <= r) {
            //System.out.println("l: " + l + ", r: " + r);
            if(l < r && people[l] + people[r] <= limit) {
                l++;
                r--;
                res++;
            }else if(l < r && people[l] + people[r] > limit) {
                r--;
                res++;
            }else if(l == r) {
                if(people[l] <= limit) {
                    res++;
                    l++;
                }
            }
        }
        return res;
    }
}
