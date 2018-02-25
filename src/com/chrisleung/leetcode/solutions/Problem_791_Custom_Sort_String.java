package com.chrisleung.leetcode.solutions;

public class Problem_791_Custom_Sort_String {
    
    public String customSortString(String S, String T) {
        int[] charCount = new int[26];
        char[] sChars = S.toCharArray();
        char[] tChars = T.toCharArray();
        for(char c : sChars) {
            charCount[c-'a']++;
        }
        for(char c: tChars) {
            charCount[c-'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : sChars) {
            if(charCount[c-'a'] <= 0) {
                for(int i=0; i>= charCount[c-'a']; i--) {
                    sb.append(c);
                }
                charCount[c-'a'] = 0;
            }
        }
        for(char c : tChars) {
            if(charCount[c-'a'] < 0) {
                sb.append(c);
                charCount[c-'a']++;
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Problem_791_Custom_Sort_String p = new Problem_791_Custom_Sort_String();
        System.out.println(p.customSortString("kqep", "pekeq"));
    }

}
