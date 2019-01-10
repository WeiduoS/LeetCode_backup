package LeetCode0773_SlidingPuzzle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
	public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        set.add(start);
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String cur = queue.poll();
                if(cur.equals(target)) return steps;
                int zero = cur.indexOf('0');
                int x = zero / 3;
                int y = zero % 3;
                //System.out.println("cur: " + cur +", x: " + x + ", y: " + y);
                for(int[] dir : dirs) {
                    int r = x + dir[0];
                    int c = y + dir[1];
                    if(r < 0 || c < 0 || r >= 2 || c >= 3) continue;
                    int next = r * 3 + c;
                    //System.out.println("next: " + next + ", r: " + r + ", c: " + c);
                    String temp = swap(cur.toCharArray(), zero, next);
                    //System.out.println("temp: " + temp);
                    if(set.contains(temp)) continue;
                    set.add(temp);
                    queue.offer(temp);
                }
            }
            steps++;
        }
        return -1;
    }

	private String swap(char[] c, int i, int j) {
		// TODO Auto-generated method stub
		char t = c[i];
        c[i] = c[j];
        c[j] = t;
        return new String(c);
	}
}
