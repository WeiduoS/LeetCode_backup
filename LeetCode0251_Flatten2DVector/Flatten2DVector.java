package LeetCode0251_Flatten2DVector;

import java.util.List;

public class Flatten2DVector {
	List<List<Integer>> list;
    int listNum = 0;
    int listIndex = 0;
    public void Vector2D(List<List<Integer>> vec2d) {
        list = vec2d;
    }

    public Integer next() {
        Integer res = list.get(listNum).get(listIndex);
        listIndex++;
        return res;
    }

    public boolean hasNext() {
        if(listNum < list.size()) {
            if(list.get(listNum) != null && listIndex < list.get(listNum).size()) {
                return true;
            }else{
                listNum++;
                if(listNum < list.size()) {
                    if(list.get(listNum) != null && list.get(listNum).size() > 0) {
                        listIndex = 0;
                        return true;
                    }else{
                        return hasNext();
                    }
                }else{
                    return false;
                }
            }
        }else{
            return false;
        }
    }	
}