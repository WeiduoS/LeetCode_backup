package LeetCode052_NQueensII;

public class NQueensII {
	public static int sum;
    public int totalNQueens(int n) {
        sum = 0;
        int[] usedColumns = new int[n];
        dfs(usedColumns, 0);
        return sum;
    }
    
    private void dfs(int[] usedColumns, int row) {
        if(row == usedColumns.length) sum++;
        for(int i = 0; i < usedColumns.length; i++) {
            if(isValid(usedColumns, row, i)) {
                usedColumns[row] = i;
                dfs(usedColumns, row + 1);
            }
        }
    }
    
    private boolean isValid(int[] usedColumns, int row, int col) {
        for(int i = 0; i < row; i++) {
            if(usedColumns[i] == col) return false;
            if((row - i) == Math.abs(col - usedColumns[i])) return false;
        }
        return true;
    }
}
