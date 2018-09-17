package LeetCode0038_CountAndSay;

public class CountAndSay {
	public String countAndSay(int n) {
        String temp = "1";
        while(n -1 > 0) {
            temp = stringToNumber(temp);
            //System.out.println(temp);
            n--;
        }
        return temp;
    }
    private String stringToNumber(String s) {
        if(s == "1") return "11";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            int count = 1;
            while(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            sb.append(count);
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }	
}