package LeetCode0419_BattleshipsInABoard;

public class BattleshipsInABoard {
	public int countBattleships(char[][] board) {
        int m = board.length;
        if(m == 0) return 0;
        int n = board[0].length;
        
        int count = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.') continue;
                if(j > 0 && board[i][j] == 'X' && board[i][j - 1] == 'X') continue;
                if(i > 0 && board[i][j] == 'X' && board[i - 1][j] == 'X') continue;
                count++;
            }
        }
        return count;
    }
}
