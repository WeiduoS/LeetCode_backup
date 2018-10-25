package LeetCode0913_CatAndMouse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CatAndMouse {
final int DRAW = 0, MOUSE = 1, CAT = 2;
    
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        
        int[][][] color = new int[50][50][3];
        int[][][] degree = new int[50][50][3];
        
        for(int m = 0; m < n; m++) {
            for(int c = 0; c < n; c++) {
                degree[m][c][1] = graph[m].length;
                degree[m][c][2] = graph[c].length;
                for(int findZero : graph[c]) {
                    if(findZero == 0) degree[m][c][2]--;
                    break;
                }
            }
        }
        //System.out.println("here");
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int t = 1; t <= 2; t++) {
                color[0][i][t] = MOUSE;
                queue.add(new int[]{0, i, t, MOUSE});
                if(i > 0) {
                    color[i][i][t] = CAT;
                    queue.add(new int[]{i, i, t, CAT});
                }
            }
        }
        
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int mousePos = node[0], catPos = node[1], turn = node[2], c = node[3];
            //System.out.println("mousePos: " + mousePos + ", catPos: " + catPos + ", turn: " + turn + ", c: " + c);
            for(int[] parent : parents(graph, mousePos, catPos, turn)) {
                int mousePrev = parent[0], catPrev = parent[1], turn2 = parent[2];
                //System.out.println("mousePrev: " + mousePrev + ", catPrev: " + catPrev + ", turn2: " + turn2);
                //System.out.println("color[mousePrev][catNext][turn2]: " + color[mousePrev][catNext][turn2]);
                if(color[mousePrev][catPrev][turn2] == DRAW) {
                    if(turn2 == c) {
                        color[mousePrev][catPrev][turn2] = c;
                        queue.add(new int[]{mousePrev, catPrev, turn2, c});
                    }else{
                        degree[mousePrev][catPrev][turn2]--;
                        if (degree[mousePrev][catPrev][turn2] == 0) {
                            color[mousePrev][catPrev][turn2] = 3 - turn2;
                            queue.add(new int[]{mousePrev, catPrev, turn2, 3 - turn2});
                        }
                    }
                }
            }
            
        }
        
        return color[1][2][1];
        
    }
    // DRAW = 0, MOUSE = 1, CAT = 2;
    public List<int[]> parents (int[][] graph, int mousePos, int catPos, int turn) {
        List<int[]> ans = new ArrayList<>();
        if(turn == 2) {
            for(int mousePrev : graph[mousePos]) {
                ans.add(new int[]{mousePrev, catPos, MOUSE});
            }
        }else{
            for(int catPrev : graph[catPos]) {
                if(catPrev > 0) {
                    ans.add(new int[]{mousePos, catPrev, CAT});
                }
            }
        }
        return ans;
    }	
}