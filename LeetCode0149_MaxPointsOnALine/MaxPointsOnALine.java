package LeetCode0149_MaxPointsOnALine;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
	// wrong answer: [[1,1],[1,1],[2,3]]
    /*
    public int maxPoints(Point[] points) {
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        Map<String, Integer> diagnalUpRight = new HashMap<>();
        Map<String, Integer> diagnalDownRight = new HashMap<>();
        for(Point point : points) {
            String uR = upRightPoint_(point);
            String dR = downRightPoint_(point);
            //System.out.println("uR: " + uR);
            //System.out.println("dR: " + dR);
            rowMap.put(point.y, rowMap.getOrDefault(point.y, 0) + 1);
            colMap.put(point.x, colMap.getOrDefault(point.x, 0) + 1);
            diagnalUpRight.put(uR, diagnalUpRight.getOrDefault(uR, 0) + 1);
            diagnalDownRight.put(dR, diagnalDownRight.getOrDefault(dR, 0) + 1);
        }
        
        int maxLine = 0;
        for(Map.Entry<Integer, Integer> entry : rowMap.entrySet()) maxLine = Math.max(maxLine, entry.getValue());
        //System.out.println("row : " + maxLine);
        for(Map.Entry<Integer, Integer> entry : colMap.entrySet()) maxLine = Math.max(maxLine, entry.getValue());
        //System.out.println("col : " + maxLine);
        for(Map.Entry<String, Integer> entry : diagnalUpRight.entrySet()) maxLine = Math.max(maxLine, entry.getValue());
        //System.out.println("diagnalUpRight : " + maxLine);
        for(Map.Entry<String, Integer> entry : diagnalDownRight.entrySet()) maxLine = Math.max(maxLine, entry.getValue());
        //System.out.println("diagnalDownRight : " + maxLine);
        
        return maxLine;
    }
    
    private String upRightPoint_(Point p) {
        int xPoint = p.x - p.y;
        int yPoint = 0;
        String res = String.valueOf(xPoint) + String.valueOf(yPoint);
        return res;
    }
    
    private String downRightPoint_(Point p) {
        int xPoint = p.x + p.y;
        int yPoint = 0;
        String res = String.valueOf(xPoint) + String.valueOf(yPoint);
        return res;
    }*/
    // failed case: [[0,0],[94911151,94911150],[94911152,94911151]]
    /*由于通过斜率来判断共线需要用到除法，而用double表示的双精度小数在有的系统里不一定准确，为了更加精确无误的计算共线，我们应当避免除法，从而避免无线不      *循环小数的出现，那么怎么办呢，我们把除数和被除数都保存下来，不做除法，但是我们要让这两数分别除以它们的最大公约数，这样例如8和4，4和2，2和1，这三组      *商相同的数就都会存到一个映射里面，同样也能实现我们的目标，而求GCD的函数如果用递归来写那么一行就搞定了，叼不叼，这个方法能很好的避免除法的出现，算是      *牺牲了空间来保证精度吧
    /*
    public  int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }  

        HashMap<Double, Integer> map=new HashMap<Double, Integer>();
        int max = 1;

        for(int i = 0 ; i < points.length; i++) {
            // shared point changed, map should be cleared and server the new point
            map.clear();

            // maybe all points contained in the list are same points,and same points' k is 
            // represented by Integer.MIN_VALUE
            map.put((double)Integer.MIN_VALUE, 1);

            int dup = 0;
            for(int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }

                // look 0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x)
                // because (double)0/-1 is -0.0, so we should use 0.0+-0.0=0.0 to solve 0.0 !=-0.0
                // problem

                // if the line through two points are parallel to y coordinator, then K(slop) is 
                // Integer.MAX_VALUE
                double key=points[j].x - points[i].x == 0 ? 
                    Integer.MAX_VALUE :
                    0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);

                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 2);
                }
            }

            for (int temp: map.values()) {
                // duplicate may exist
                if (temp + dup > max) {
                    max = temp + dup;
                }
            }

        }
        return max;
    }*/
	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
    public int maxPoints(Point[] points) {
        int res = 0;
        for(int i = 0; i < points.length; i++) {
            Map<Map<Integer, Integer>, Integer> map = new HashMap<>();
            int dup = 1;
            for(int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }
                
                int dx = points[j].x - points[i].x;
                int dy = points[j].y - points[i].y;
                int d = gcd(dx, dy);
                
                Map<Integer, Integer> t = new HashMap<>();
                t.put(dx / d, dy / d);
                
                map.put(t, map.getOrDefault(t, 0) + 1);
            }
            res = Math.max(dup, res);
            for(Map.Entry<Map<Integer, Integer>, Integer> entry : map.entrySet()) res = Math.max(res, entry.getValue() + dup);
        }
        
        return res;
    }
    
    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }	
}