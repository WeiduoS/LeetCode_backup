package LeetCode0497_RandomPointInNonoverlappingRectangles;

import java.util.Random;
import java.util.TreeMap;

public class RandomPointInNonoverlappingRectangles {
	/*
    int[][] rects;
    Random rand;
    public Solution(int[][] rects) {
        rand = new Random();
        this.rects = rects;
    }
    
    public int[] pick() {
        int sum = 0;
        int[] pick = new int[]{};
        for(int[] rec : rects) {
            int area = (rec[2] - rec[0] + 1) * (rec[3] - rec[1]  + 1);
            sum += area;
            if(rand.nextInt(sum) < area) pick = rec;
        }
        int x = rand.nextInt(pick[2] - pick[0] + 1) + pick[0];
        int y = rand.nextInt(pick[3] - pick[1] + 1) + pick[1];
        return new int[]{x, y};
    }*/
    int[][] rects;
    Random rand;
    TreeMap<Integer, Integer> tree;
    int area;
    public void Solution(int[][] rects) {
        this.rects = rects;
        rand = new Random();
        tree = new TreeMap<>();
        area = 0;
        for(int i = 0; i < rects.length; i++) {
            area += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1]  + 1);
            tree.put(area, i);
        } 
    }
    
    public int[] pick() {
        int r = rand.nextInt(area);
        int pick = tree.higherKey(r);
        int[] rec = rects[tree.get(pick)];
        int x = rand.nextInt(rec[2] - rec[0] + 1) + rec[0];
        int y = rand.nextInt(rec[3] - rec[1] + 1) + rec[1];
        return new int[]{x, y};
        
    }
}
