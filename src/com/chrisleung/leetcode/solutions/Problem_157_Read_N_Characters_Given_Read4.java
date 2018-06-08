package com.chrisleung.leetcode.solutions;

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */
public class Problem_157_Read_N_Characters_Given_Read4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] tmpBuf = new char[4];
    private int tmpIndex = 0;
    private int tmpCharsLeft = 0;
    private boolean eof = false;
    
    public int read(char[] buf, int n) {
        int outputIndex = 0; // Same as chars read
        while(outputIndex < n && !(eof && tmpCharsLeft == 0)) {
            if(tmpCharsLeft > 0) {
                buf[outputIndex] = tmpBuf[tmpIndex];
                tmpIndex++;
                outputIndex++;
                tmpCharsLeft--;
            }
            if(tmpCharsLeft == 0 && !eof) {
                tmpCharsLeft = read4(tmpBuf);
                if(tmpCharsLeft < 4) {
                    eof = true;
                }
                tmpIndex = 0;
            }
        }
        return outputIndex;
    }
}
