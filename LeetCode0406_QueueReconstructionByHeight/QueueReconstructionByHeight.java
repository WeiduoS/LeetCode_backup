package LeetCode0406_QueueReconstructionByHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {
	/*
     * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     *
     * [5,0] [[7,0], [4,3], [7,1], [6,1], [5,1]]
     * [5,0] [7,1] [[4,2], [7,0], [6,0], [5,0]]
     * [5,0] [7,1] [5,2] [[4,1], [7,0], [6,0]]
     * [5,0] [7,1] [5,2] [6,1] [[4,0], [7,0]]
     * [5,0] [7,1] [5,2] [6,1] [4,4] [[7,0]]
     * [5,0] [7,1] [5,2] [6,1] [4,4] [7,1]
     *
     */
     public int[][] reconstructQueue(int[][] people) {
         if(people == null || people.length == 0 || people[0].length == 0) return new int[0][0];
     
         Arrays.sort(people, new Comparator<int[]>() {
             public int compare(int[] a, int[] b) {
                 if(b[0] == a[0]) return a[1] - b[1];
                 return b[0] - a[0];
             }
         });
         // Arrays.sort(people, (a, b) -> (b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]));
     
         List<int[]> res = new ArrayList<>();
         for (int[] p : people) {
             res.add(p[1], p);
         }
         return res.toArray(new int[0][0]);
     }
}