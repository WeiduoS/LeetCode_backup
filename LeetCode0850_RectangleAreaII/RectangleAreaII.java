package LeetCode0850_RectangleAreaII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class RectangleAreaII {
	/* binary	decimal	sets
     * 000	(0)	[]
     * 001	(1)	[A]
     * 010	(2)	[B]
     * 011	(3)	[A, B]
     * 100	(4)	[C]
     * 101	(5)	[A, C]
     * 110	(6)	[B, C]
     * 111	(7)	[A, B, C] */
    // if the group has an odd number of sets (one, three, five, etc.),then we have a + sign
    // if the group has an even number of sets (two, four, etc.), then we have the - sign. 
    //  Time Limit Exceeded
    /*
    public int rectangleArea(int[][] rectangles) {
        int n = rectangles.length;
        long ans = 0;
        for(int subset = 1; subset < (1 << n); subset++) {
            int[] res = new int[]{0, 0, 1_000_000_000, 1_000_000_000};
            int parity = -1;
            for(int bit = 0; bit < n; bit++) {
                if(((subset >> bit) & 1) != 0) {
                    res = intersect(res, rectangles[bit]);
                    parity *= -1;
                }
            }
            ans += parity * area(res);
        }
        long MOD = 1_000_000_000 + 7;
        ans = (ans + MOD) % MOD;
        return (int) ans;
    }
    private long area(int[] res) {
        // add the check here
        long x = Math.max(0, res[2] - res[0]);
        long y = Math.max(0, res[3] - res[1]);
        return x * y;
    }
    private int[] intersect(int[] rec1, int[] rec2) {
        // did not check wether overlaped
        return new int[]{ Math.max(rec1[0], rec2[0]), Math.max(rec1[1], rec2[1]), Math.min(rec1[2], rec2[2]), Math.min(rec1[3], rec2[3])};
    }*/
    /*
    public int rectangleArea(int[][] rectangles) {
        int[][] vert = new int[rectangles.length * 2][];
        int index = 0;
        for(int[] rec : rectangles) {
            vert[index++] = new int[]{rec[1], rec[0], rec[2], 1};
            vert[index++] = new int[]{rec[3], rec[0], rec[2], -1};
        }
        Arrays.sort(vert, (a, b) -> (a[0] - b[0]));
        List<int[]> overlaps = new ArrayList<>();
        int cur_y = vert[0][0];
        long res = 0;
        for(int[] rec : vert) {
            int y = rec[0];
            
            int cur = -1;
            long inter = 0;
            for(int[] overlap : overlaps) {
                cur = Math.max(cur, overlap[0]);
                inter += Math.max(overlap[1] - cur, 0);
                cur = Math.max(cur, overlap[1]);
            }
            res += inter * (y - cur_y);
            
            if(rec[3] == 1) {
                overlaps.add(new int[]{rec[1], rec[2]});
                Collections.sort(overlaps, (a, b) -> Integer.compare(a[0], b[0]));
            }else{
                for(int i = 0; i < overlaps.size(); i++) {
                    if(overlaps.get(i)[0] == rec[1] && overlaps.get(i)[1] == rec[2]) {
                        overlaps.remove(i);
                    }
                }
            }
            cur_y = y;
        }
        
        res %= 1_000_000_007;
        return (int)res;
    }*/
    class Point {
        int x, y, val;
        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public int rectangleArea(int[][] rectangles) {
        int M = 1_000_000_007;
        List<Point> data = new ArrayList<>();
        for(int[] rec : rectangles) {
            data.add(new Point(rec[0], rec[1], 1));
            data.add(new Point(rec[0], rec[3], -1));
            data.add(new Point(rec[2], rec[1], -1));
            data.add(new Point(rec[2], rec[3], 1));
        }
        
        Collections.sort(data, (a, b) -> {
            if(a.x == b.x) return b.y - a.y;
            return a.x - b.x;
        });
        
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        int preX = data.get(0).x;
        int preY = -1;
        int result = 0;
        for(int i = 0; i < data.size(); i++) {
            Point p = data.get(i);
            tree.put(p.y, tree.getOrDefault(p.y, 0) + p.val);
            if(i == data.size() - 1 || data.get(i + 1).x > p.x) {// the different x-aixs generate a new rectangle
                result += ((long)preY * (p.x - preX)) % M;
                result %= M;
                preY = calcY(tree);
                preX = p.x;
            }
        }
        return result;
    }
    
    private int calcY(TreeMap<Integer, Integer> map) {
        int result = 0, pre = -1, count = 0;
        for (Entry<Integer, Integer> e : map.entrySet()) {
            if (pre >= 0 && count > 0) {
                result += e.getKey() - pre;
            }
            count += e.getValue();
            pre = e.getKey();
        }
        return result;
    }
}
