package LeetCode0119_PascalTriangleII;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	 public List<Integer> getRow(int rowIndex) {
	        List<List<Integer>> list = new ArrayList<List<Integer>>();
	        
	        // Initialization
	        list.add(new ArrayList<>());
	        list.get(0).add(1);
	        
	        if(rowIndex == 0) return list.get(0);
	        
	        for(int i = 1; i <= rowIndex; i++){
	            List<Integer> subList = new ArrayList<>();
	            List<Integer> upperLayer = new ArrayList<>();
	            upperLayer = list.get(i - 1);
	            
	            subList.add(1);
	            
	            for(int j = 1; j < i; j++){
	                subList.add(upperLayer.get(j - 1) + upperLayer.get(j));
	            }
	            subList.add(1);
	            list.add(subList);
	            
	        }
	        
	        //System.out.println(Arrays.toString(list.toArray()));
	        
	        return list.get(rowIndex); 
	        
	    }
}