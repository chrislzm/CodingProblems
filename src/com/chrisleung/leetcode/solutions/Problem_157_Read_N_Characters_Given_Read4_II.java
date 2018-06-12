package com.chrisleung.leetcode.solutions;

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */
public class Problem_157_Read_N_Characters_Given_Read4_II {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int totalRead = 0;
        char[] tmp = new char[4];
        boolean eof = false;
        while(!eof) {
            int charsRead = read4(tmp);
            if(charsRead < 4) {
                eof = true;
            }
            for(int i=0; i<charsRead && totalRead < n; i++) {
                buf[totalRead] = tmp[i];
                totalRead++;
            }
        }
        return totalRead;
    }
}
