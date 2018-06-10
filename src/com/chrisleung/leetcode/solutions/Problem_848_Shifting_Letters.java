package com.chrisleung.leetcode.solutions;

public class Problem_848_Shifting_Letters {
    public String shiftingLetters(String S, int[] shifts) {
        int prev = 0;
        for(int i=shifts.length-1; i>=0; i--) {
            shifts[i] = ((shifts[i]%26) + prev)%26;
            prev = shifts[i];
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        for(char C : S.toCharArray()) {
            int shift = shifts[i++]%26;
            int c = ((C - 'a' + shift)%26)+'a';
            sb.append((char)c);
        }
        return sb.toString();
    }
}
