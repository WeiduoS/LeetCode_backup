package LeetCode0157_ReadNCharactersGivenReadFour;

public class ReadNCharactersGivenReadFour {
	public int read(char[] buf, int n) {
        int index = 0;
        char[] temp = new char[4];
        while(index < n) {
            int delta = read4(temp);
            for(int i = 0; i < delta && index < n; i++) {
                buf[index++] = temp[i];
            }
            if(delta < 4) break;
        }
        return index;
    }

	private int read4(char[] temp) {
		// TODO Auto-generated method stub
		return 0;
	}
}
