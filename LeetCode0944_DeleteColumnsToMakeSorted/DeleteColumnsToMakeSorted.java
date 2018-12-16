package LeetCode0944_DeleteColumnsToMakeSorted;

public class DeleteColumnsToMakeSorted {
	public int minDeletionSize(String[] A) {
        int res = 0;
        for(int i = 0; i < A[0].length(); i++) {
            for(int j = 0; j < A.length - 1; j++) {
                if(A[j + 1].charAt(i) < A[j].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
