package LeetCode0400_NthDigit;

public class NthDigit {
	public int findNthDigit(int n) {
        int len = 1, start = 1;
        long cnt = 9;
        while(n > len * cnt) {
            n -= len * cnt;
            len ++;
            cnt *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String t = String.valueOf(start);
        //System.out.println("start: " + start + ", t: " + t+ ", n - 1 " + (n - 1) + ", len: " + len);
        return t.charAt((n - 1 ) % len) - '0';
		//return Character.getNumericValue(t.charAt((n - 1) % len));
    }
}
