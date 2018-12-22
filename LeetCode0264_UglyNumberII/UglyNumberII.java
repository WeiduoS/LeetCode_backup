package LeetCode0264_UglyNumberII;

import java.util.ArrayList;
import java.util.List;

public class UglyNumberII {
	public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        
        while(list.size() < n) {
            int m2 = list.get(i2) * 2, m3 = list.get(i3) * 3, m5 = list.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            
            if(min == m2) i2++;
            if(min == m3) i3++;
            if(min == m5) i5++;
            list.add(min);
        }
        return list.get(list.size() - 1);
    }
}
