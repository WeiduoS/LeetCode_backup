package LeetCode0668_KthSmallestNumberInMultiplicationTable;

public class KthSmallestNumberInMultiplicationTable {
	public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while(left < right) {
            int mid = left + (right - left) / 2, cnt = 0;
            for(int i = 1; i <= m; i++) {
                cnt += (mid > n * i) ? n : (mid / i);
            }
            if(cnt >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
