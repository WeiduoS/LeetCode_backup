package LeetCode0051_NQueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if(n <= 0) return results;
        backtracking(results, new ArrayList<Integer>(), n);
        return results;
    }
    
    private void backtracking(List<List<String>> results, List<Integer> cols, int n) {
        if(cols.size() == n) {
            results.add(drawChessBoard(cols));
            return;
        }
        
        for(int colIndex = 0; colIndex < n; colIndex++) {
            if(!isValid(cols, colIndex)) continue;
            cols.add(colIndex);
            backtracking(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }
    
    private boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();
        for(int rowIndex = 0; rowIndex < row; rowIndex++) {
            if(cols.get(rowIndex) == column) return false;
            if(rowIndex - cols.get(rowIndex) == row - column) return false;
            if(rowIndex + cols.get(rowIndex) == row + column) return false;
        }
        return true;
    }
    
    private List<String> drawChessBoard(List<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        for(int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }
}
