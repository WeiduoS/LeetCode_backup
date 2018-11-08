package LeetCode0271_EncodeAndDecodeStrings;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length()).append('/').append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while(index < s.length()) {
            int slash = s.indexOf('/', index);
            int size = Integer.valueOf(s.substring(index, slash));
            res.add(s.substring(slash + 1, slash + size + 1));
            index = slash + size + 1;
        }
        return res;
    }
}
