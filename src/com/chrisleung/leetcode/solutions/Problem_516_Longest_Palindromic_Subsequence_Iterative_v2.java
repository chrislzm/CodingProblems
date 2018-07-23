package com.chrisleung.leetcode.solutions;

/*
 * Alternative bottom-up approach
 */
public class Problem_516_Longest_Palindromic_Subsequence_Iterative_v2 {
    
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.isEmpty()) return 0;
        char[] str = s.toCharArray();
        int[][] table = new int[str.length][str.length];
        for(int i=0; i<str.length; i++) {
            table[i][i] = 1; // Base case
        }
        for(int winSize=2; winSize<=str.length; winSize++) {
            for (int startIndex=0; startIndex<=str.length-winSize; startIndex++) {
                int endIndex = startIndex+winSize-1;
                if(str[startIndex] == str[endIndex]) {
                    table[startIndex][endIndex] = 2 + table[startIndex+1][endIndex-1];
                } else {
                    table[startIndex][endIndex] = Math.max(table[startIndex+1][endIndex],table[startIndex][endIndex-1]);
                }
            }
        }
        return table[0][str.length-1];
    }
    
}
