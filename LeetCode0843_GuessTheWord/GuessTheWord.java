package LeetCode0843_GuessTheWord;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessTheWord {
	//Random rand = new Random();
    public void findSecretWord(String[] wordlist, Master master) {
        for(int i = 0, x = 0; i < 10 && x < 6; i++) {
            String guess = wordlist[new Random().nextInt(wordlist.length)];
            x =  master.guess(guess);
            List<String> new_wordlist = new ArrayList<>();
            for(String word : wordlist) {
                if(match(guess, word) == x) new_wordlist.add(word);
            }
            wordlist = new_wordlist.toArray(new String[new_wordlist.size()]);
        }
    }
    
    private int match(String guess, String word) {
        int count = 0;
        for(int i = 0; i < 6; i++) {
            if(guess.charAt(i) == word.charAt(i)) count++;
        }
        return count;
    }
}
