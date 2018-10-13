package LeetCode0277_FindTheCelebrity;

public class FindTheCelebrity {
	public int findCelebrity(int n) {
        int celebrity = 0;
        for(int i = 0; i < n; i++) {
            if(knows(celebrity, i)) {
                celebrity = i;
            }
        }
        for(int i = 0; i < n; i++) {
            if(celebrity != i && (knows(celebrity, i) || !knows(i, celebrity))) return -1;
        }
        return celebrity;
    }

	private boolean knows(int celebrity, int i) {
		// TODO Auto-generated method stub
		return false;
	}	
}