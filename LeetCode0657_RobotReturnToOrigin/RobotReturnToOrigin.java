package LeetCode0657_RobotReturnToOrigin;

public class RobotReturnToOrigin {
	public boolean judgeCircle(String moves) {
        int[] pos = {0, 0};
        for(int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            int[] dir = findDir(c);
            pos[0] += dir[0];
            pos[1] += dir[1];
        }
        
        return pos[0] == 0 && pos[1] == 0;
    }
    
    private int[] findDir(char c) {
        if(c == 'U') {
            return new int[]{-1, 0};
        }else if(c == 'D') {
            return new int[]{1, 0};
        }else if(c == 'L') {
            return new int[]{0, -1};
        }else{
            return new int[]{0, 1};
        }
    }
    /*
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }*/
}
