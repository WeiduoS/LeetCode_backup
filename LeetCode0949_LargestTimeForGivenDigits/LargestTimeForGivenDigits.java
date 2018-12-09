package LeetCode0949_LargestTimeForGivenDigits;

public class LargestTimeForGivenDigits {
	/*
    public String largestTimeFromDigits(int[] A) {
       for(int i = 2439; i >= 0; i--) {
           int[] visited = new int[10];
           for(int digit : A) visited[digit]++;
           int hour_f = i / 60 / 10;
           int hour_s = i / 60 % 10;
           int min_f = i % 60 / 10;
           int min_s = i % 60 % 10;
           if(i / 60 > 23 || i % 60 > 59) continue;
           //System.out.println(String.format("%02d:%02d", i / 60, i % 60));
           //System.out.println(Arrays.toString(visited));
           if(visited[hour_f] > 0) {
               visited[hour_f]--;
           }else{
               continue;
           }
           
           if(visited[hour_s] > 0) {
               visited[hour_s]--;
           }else{
               continue;
           }
           
           if(visited[min_f] > 0) {
               visited[min_f]--;
           }else{
               continue;
           }
           
           if(visited[min_s] > 0) {
               visited[min_s]--;
           }else{
               continue;
           }

           return String.format("%02d:%02d", i / 60, i % 60);
       }
       return "";
   }*/
   int ans = -1;
   public String largestTimeFromDigits(int[] A) {
       boolean[] visited = new boolean[A.length];
       backtracking(A, visited, 4, 0);
       if(ans == -1) return "";
       return String.format("%02d:%02d", ans / 100, ans % 100);
   }
   
   private void backtracking(int[] A, boolean[] visited, int level, int cur) {
       if(level == 0) {
           //System.out.println("cur: " + cur);
           if((cur / 100) <= 23 && (cur % 100) <= 59) ans = Math.max(ans, cur);
           else return;
       }

       for(int i = 0; i < A.length; i++) {
           if(visited[i] == true) continue;
           if(level == 4)  cur += 1000 * A[i];
           if(level == 3)  cur += 100 * A[i];
           if(level == 2)  cur += 10 * A[i];
           if(level == 1)  cur += A[i];
           visited[i] = true;
           backtracking(A, visited, level - 1, cur);
           visited[i] = false;
           if(level == 4)  cur -= 1000 * A[i];
           if(level == 3)  cur -= 100 * A[i];
           if(level == 2)  cur -= 10 * A[i];
           if(level == 1)  cur -= A[i];
       }
       return;
   }
}
