package LeetCode0683_KEmptySlots;

public class KEmptySlots {
	/*           0  1  2  3  4  5   6  7  8  9
     * flowers: [6, 5, 8, 9, 7, 1, 10, 2, 3, 4]
     * days :   [6, 8, 9, 10, 2, 1, 5, 3, 4, 7]
     *
     */
/*
// solution 1: silding windows
public int kEmptySlots(int[] flowers, int k) {
    int[] days = new int[flowers.length];
    for (int i = 0; i < flowers.length; i++) days[flowers[i] - 1] = i + 1;
    // System.out.println(Arrays.toString(flowers));
    // System.out.println(Arrays.toString(days));
    
    int left = 0, right = k + 1, result = Integer.MAX_VALUE;
    for (int i = 0; right < days.length; i++) {
        System.out.println("i:" + i + ", left: " + left + ", right: " + right);
        if (days[i] < days[left] || days[i] <= days[right]) {
            if (i == right)
                result = Math.min(result, Math.max(days[left], days[right]));
            left = i;
            right = k + 1 + i;
        }
    }

    return (result == Integer.MAX_VALUE) ? -1 : result;
}*/

// solution 2: tree set
/*
public int kEmptySlots(int[] flowers, int k) {
    TreeSet<Integer> tree = new TreeSet<>();
    for(int i = 0; i < flowers.length; i++) {
        tree.add(flowers[i]);
        Integer lower = tree.lower(flowers[i]);
        Integer higher = tree.higher(flowers[i]);
        
        if(lower != null && flowers[i] - lower == k + 1) return i + 1;
        if(higher != null && higher - flowers[i] == k + 1) return i + 1;
    }
    
    return -1;
}*/

// solution 3: buckets sort
// the busket is not vaild in java

public int kEmptySlots(int[] flowers, int k) {
    int n = flowers.length; 
    ++k; 
    int bs = n / k + 1;
    //System.out.println(bs);
    int[] lows = new int[bs];
    int[] highs = new int[bs];
    for(int i = 0; i < lows.length; i++){
        lows[i] = Integer.MAX_VALUE;
        highs[i] = Integer.MIN_VALUE;
    }
    // flowers[i] = x means that the unique flower that blooms at day i will be at position x
    for(int i = 0; i < n; i++) {
        //System.out.println(Arrays.toString(lows));
        //System.out.println(Arrays.toString(highs));
        int x = flowers[i];
        int p = x / k;
        //System.out.println("flowers[i]: " + flowers[i] + " , bucket: " + p);
        if(x < lows[p]) {
            lows[p] = x;
            if(p > 0 && highs[p - 1] == x - k) return i + 1;
        }
        if (x > highs[p]) {
            highs[p] = x;
            if (p < bs - 1 && lows[p + 1] == x + k) return i + 1;
        } 
    }
    
    return -1;
}
}
