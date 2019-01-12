package LeetCode0845_LongestMountainInArray;

public class LongestMountainInArray {
	public int longestMountain(int[] A) {
        int l = 0, r = 0, res = 0;
        while(l < A.length - 1 && r < A.length - 1) {
            while(l < A.length - 1 && A[l + 1] <= A[l]) l++;
            r = l + 1;
            while(r < A.length - 1 && A[r + 1] > A[r]) r++;

            while(r < A.length - 1 && A[r + 1] < A[r]) {
                r++;
                res = Math.max(r - l + 1, res);
            }
            l = r;
        }
        return res;
    }
}
