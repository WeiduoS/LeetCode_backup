package LeetCode0119_PascalTriangleII;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	 public List<Integer> getRowI (int rowIndex) {
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
	 public List<Integer> getRowII(int rowIndex) {
		 List<Integer> list = new ArrayList<>();
	     list.add(1);
	     if(rowIndex == 0) return list;
	     list.add(1);
	     int pre = 0;
	     int curr = 0;
	     
	     for(int i = 1; i < rowIndex; i++){
	    	 pre = list.get(0);
	    	 curr = list.get(1);
	    	 list.add(1);
	         for(int j = 1; j <= i ; j++){
	        	 list.set(j, pre + curr);
	        	 pre = curr;
	        	 curr = list.get(j + 1);
	             //System.out.println("j:"+ j + Arrays.toString(list.toArray())+ ", pre: " + pre +", curr: " + curr);
	        }
	    }   
	    return list;
	 }
	 public List<Integer> getRowIII(int rowIndex) {
		 List<Integer> list = new ArrayList<Integer>();
		 if (rowIndex < 0) return list;

		 for (int i = 0; i < rowIndex + 1; i++) {
			 list.add(0, 1);
			 for (int j = 1; j < list.size() - 1; j++) {
				 list.set(j, list.get(j) + list.get(j + 1));
			 }
		}
		return list;
	 }
	 
	 public List<Integer> getRowIV(int rowIndex) {
		 List<Integer> list = new ArrayList<Integer>();
		 list.add(1);
		 if(rowIndex == 0) return list;
	        
	     int t = rowIndex, b = 1;
	     long curr = 1;
	        
	     for(int i = 1; i < rowIndex + 1; i++) {
	    	 curr = curr * t;
	         curr = curr / b;
	         list.add((int)curr);
	         t--;
	         b++;
	     }
	    return list;
	 }
	 
	 
	 
	 
}