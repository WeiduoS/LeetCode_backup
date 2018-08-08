package LeetCode0599_MinimumIndexSumOfTwoLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }
        
        int minSum = Integer.MAX_VALUE;
        int tempSum = 0;
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i])){
                tempSum = map.get(list2[i]) + i;
                if(tempSum < minSum){
                    res.clear();
                    res.add(list2[i]);
                    minSum = tempSum;
                }else if (tempSum == minSum){
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}