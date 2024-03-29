package LeetCode0367_ValidPerfectSquare;

public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
}