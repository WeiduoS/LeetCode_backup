package LeetCode0936_StampingTheSequence;

import java.util.ArrayList;
import java.util.List;

public class StampingTheSequence {
	public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        boolean[] visited = new boolean[t.length];
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while(count < t.length) {
            boolean canMatch = false;
            for(int i = 0; i <= t.length - s.length; i++) {
                if(visited[i]) continue;
                int j;
                for(j = 0; j < s.length; j++) {
                    //System.out.println("t[i + j]: " + t[i + j] + ", s[j]: " + s[j]);
                    if(i + j < t.length && t[i + j] != '*' && t[i + j] != s[j]) break;
                }
                //System.out.println("i: " + i + ", j: " + j);
                if(j == s.length) {
                    canMatch = true;
                    visited[i] = true;
                    for(int k = 0; k < s.length; k++) {
                        if(i + k < t.length && t[i + k] != '*'){
                            count++;
                            t[i + k] = '*';
                        }
                    }
                    list.add(i);
                }
            }
            if(!canMatch) return new int[0];
            //System.out.println(Arrays.toString(t));
            //System.out.println(Arrays.toString(visited));
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(res.length - i - 1);
        }
        return res;
    }
}
