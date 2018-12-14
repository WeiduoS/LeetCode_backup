package LeetCode0849_MaximizeDistanceToClosestPerson;

public class MaximizeDistanceToClosestPerson {
	public int maxDistToClosest(int[] seats) {
        int ans = 0, zeros = 0;
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 0) zeros++;
            else zeros = 0;
            ans = Math.max((zeros + 1) / 2, ans);
        }
        //System.out.println(ans);
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 1) {
                ans = Math.max(i, ans);
                break;
            }
        }
        for(int i = seats.length - 1; i >= 0; i--) {
            if(seats[i] == 1) {
                ans = Math.max(seats.length - 1 - i, ans);
                break;
            }
        }
        return ans;
    }
}
