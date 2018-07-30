package LeetCode0118_PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(numRows == 0) return res;
        
        // initialize the first row
        res.add(new ArrayList<>());
        res.get(0).add(1);
        
        for(int rowNum = 1; rowNum < numRows; rowNum++){
            List<Integer> temp = new ArrayList<>();
            List<Integer> upLayer = res.get(rowNum - 1);
            
            temp.add(1);
            
            for(int j = 1; j < rowNum; j++){
                temp.add(upLayer.get(j - 1) + upLayer.get(j));
            }
            
            temp.add(1);
            res.add(temp);
        }
        
        return res;
        
    }
}