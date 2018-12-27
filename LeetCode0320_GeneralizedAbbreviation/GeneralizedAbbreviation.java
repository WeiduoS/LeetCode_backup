package LeetCode0320_GeneralizedAbbreviation;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        /* 0000 word
         * 0001 wor1
         * 0010 wo1d
         * 0011 wo2
         * 0100 w1rd
         * 0101 w1r1
         * 0110 w2d
         * 0111 w3
         * 1000 1ord
         * 1001 1or1
         * 1010 1o1d
         * 1011 1o2
         * 1100 2rd
         * 1101 2r1
         * 1110 3d
         * 1111 4
         */
        for(int i = 0; i < Math.pow(2, word.length()); i++) {
            String temp = "";
            int count = 0;
            for(int j = 0; j < word.length(); j++) {
                if(((i >> j) & 1) == 1) count++;
                else {
                    if(count != 0) {
                        temp += String.valueOf(count);
                        count = 0;
                    }
                    temp += word.charAt(j);
                }
            }
            // 1111 4
            if(count > 0) temp += String.valueOf(count);
            res.add(temp);
        }
        return res;
    }
}
