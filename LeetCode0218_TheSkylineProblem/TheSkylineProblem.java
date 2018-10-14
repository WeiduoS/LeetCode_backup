package LeetCode0218_TheSkylineProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class TheSkylineProblem {
	// https://github.com/mission-peace/interview/blob/master/src/com/interview/geometry/SkylineDrawing.java
    // https://www.youtube.com/watch?v=GSBLe8cKu0s
    static class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        boolean isStart;
        int height;
        
        @Override
        public int compareTo(BuildingPoint o) {
            /* first compare by x.
             * If they are same then use this logic
             * if two starts are compared then higher height building should be picked first
             * if two ends are compared then lower height building should be picked first
             * if one start and end is compared then start should appear before end
             */
            if(this.x != o.x) {
                return this.x - o.x;
            }else{
                return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
            }
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
        int index = 0;
        for(int building[] : buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].isStart = true;
            buildingPoints[index].height = building[2];
            
            buildingPoints[index + 1] = new BuildingPoint();
            buildingPoints[index + 1].x = building[1];
            buildingPoints[index + 1].isStart = false;
            buildingPoints[index + 1].height = building[2];
            index += 2;
        }
        Arrays.sort(buildingPoints);
        //using TreeMap because it gives log time performance.
        //PriorityQueue in java does not support remove(object) operation in log time.
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        //PriorityQueue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
        queue.put(0, 1);
        //queue1.add(0);
        int prevMaxHeight = 0;
        List<int[]> result = new ArrayList<>();
        for(BuildingPoint buildingPoint : buildingPoints) {
            //if it is start of building then add the height to map. If height already exists then increment
            //the value
            if(buildingPoint.isStart == true) {
                queue.compute(buildingPoint.height, (key, value) -> {
                    if(value != null) {
                        return value + 1;
                    }else{
                        return 1;
                    }
                });
                //  queue1.add(cp.height);
            }else{
                queue.compute(buildingPoint.height, (key, value) -> {
                    if(value == 1) {
                        return null;
                    }else{
                        return value - 1;
                    }
                });
                // queue1.remove(cp.height);
            }
            //peek the current height after addition or removal of building x.
            int currentMaxHeight = queue.lastKey();
            //int currentMaxHeight = queue1.peek();
            //if height changes from previous height then this building x becomes critcal x.
            // So add it to the result.
            if(prevMaxHeight != currentMaxHeight) {
                result.add(new int[]{buildingPoint.x, currentMaxHeight});
                prevMaxHeight = currentMaxHeight;
            }
        }
        return result;
    }
}