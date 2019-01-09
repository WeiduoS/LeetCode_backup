package LeetCode0722_RemoveComments;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
	public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean hasb = false;
        StringBuilder sb = new StringBuilder();     
        for(String str : source) {
            char[] s = str.toCharArray();
            for(int i = 0; i < s.length; i++) {
                if(hasb) {
                    if(i + 1 < s.length && s[i] == '*' && s[i + 1] == '/') {
                        hasb = false;
                        i++;
                    }
                }else{
                    if(i + 1 < s.length && s[i] == '/' && s[i + 1] == '*') {
                        hasb = true;
                        i++;
                    }else if(i + 1 < s.length && s[i] == '/' && s[i + 1] == '/') {
                        i++;
                        break;
                    }else if(!hasb) {
                        sb.append(s[i]);
                        //System.out.println(sb.toString());
                    }
                }
            }
            if(!hasb && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}
