package LeetCode0955_DeleteColumnsToMakeSortedII;

public class DeleteColumnsToMakeSortedII {
	public int minDeletionSize(String[] A) {
        int res = 0, n = A.length, i, j;
        boolean[] sortedCol = new boolean[n];
        
        for(j = 0; j < A[0].length(); j++) {
            for(i = 0; i < n - 1; i++) {
                if(!sortedCol[i] && A[i].charAt(j) > A[i + 1].charAt(j)) {
                    res++;
                    break;
                }
            }
            if(i < n - 1) continue;
            for(i = 0; i < n - 1; i++) {
                if (A[i].charAt(j) < A[i + 1].charAt(j))
                    sortedCol[i] = true;
            }
        }
        return res;
    }
}
