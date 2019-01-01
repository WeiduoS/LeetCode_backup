package LeetCode0825_FriendsOfAppropriateAges;

public class FriendsOfAppropriateAges {
	public int numFriendRequests(int[] ages) {
        int n = ages.length;
        int[] count = new int[121];
        
        for(int age : ages) count[age]++;
        
        int res = 0;
        
        for(int A = 1; A <= 120; A++) {
            for(int B = (int)(A * 0.5 + 7) + 1; B <= A; B++) {
                if(A == B) {
                    res += count[A] * (count[A] - 1);
                }else {
                    res += count[A] * count[B];
                }
            }
        }
        return res;
    }
}
