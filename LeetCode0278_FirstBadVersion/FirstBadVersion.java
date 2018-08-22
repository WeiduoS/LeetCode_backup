package LeetCode0278_FirstBadVersion;

public class FirstBadVersion {
	public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while(l < r) {
            int m = l + (r - l) / 2;
            boolean res = isBadVersion(m);
            System.out.println(m);
            if(res == true) {
                r = m;
            }else{
                l = m + 1;
            }       
        }
        return l;
    }
	private boolean isBadVersion(int n) {
		if(n >= 4) {
			return true;
		}else {
			return false;
		}
	}
}