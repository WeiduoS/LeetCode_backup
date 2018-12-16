package LeetCode0754_ReachANumber;

public class ReachANumber {
	public int reachNumber(int target) {
        /*
         * 1 + 2 + 3 + 4 + ... + k = target + d
         * if d == 0:      k is answer
         * if d % 2 == 0:  1 + 2 + 3 + 4 - i + ... + k = target, d = i / 2
         * if d % 2 == 1: 
         *          1. k % 2 == 0: 1 + 2 + 3 + 4 - i + ... + k + (k + 1) = target
         *                         i = ((k + 1) + d) / 2 <= k
         *          2. k % 2 == 1: 1 + 2 + 3 + 4 - i + ... + k + (k + 1) +(k + 2) = target
         *                         i = ((k + 2) - (k + 1) + d) / 2 = (d + 1) / 2 <= k
         */
        target = Math.abs(target);
        int sum = 0, k = 0;
        while(sum < target) sum += ++k;
        int d = sum - target;
        if(d % 2 == 0) return k;
        return (k + 1) + (k % 2);
    }
}
