package LeetCode0068_TextJustification;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int cur = 0;
        while(cur < words.length) {
            int next = cur + 1;
            int cnt = words[cur].length();
            while(next < words.length) {
                if(words[next].length() + cnt + 1 > maxWidth) break;
                cnt += words[next++].length() + 1;
            }
            
            int gap = next - cur - 1;
            //System.out.println("cnt: " + cnt + ", gap: " + gap);
            StringBuilder sb = new StringBuilder();
            if(next == words.length || gap == 0) { // 到了最后一行或者只有一个单词
                for(int i = cur; i < next; i++) {
                    if(i != next - 1) sb.append(words[i] + " ");
                    else sb.append(words[i]);
                }
                for(int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            }else{
                int space = (maxWidth - cnt) / gap;
                int rem = (maxWidth - cnt) % gap;
                //System.out.println("space: " + space + ", rem:" + rem);
                for(int i = cur; i < next; i++) {
                    sb.append(words[i]);
                    if(i != next - 1) {
                        for(int j = 0; j <= space; j++) sb.append(" "); 
                        if(rem-- > 0) sb.append(" ");
                    }
                }
            }
            lines.add(sb.toString());
            cur = next;
        }
        return lines;
    }
}
