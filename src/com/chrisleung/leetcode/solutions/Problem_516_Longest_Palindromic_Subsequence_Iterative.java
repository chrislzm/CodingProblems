package com.chrisleung.leetcode.solutions;

public class Problem_516_Longest_Palindromic_Subsequence_Iterative {
    
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.isEmpty()) return 0;
        char[] str = s.toCharArray();
        int[][] table = new int[str.length][str.length];
        for(int i=0; i<str.length; i++) {
            table[i][i] = 1;
        }
        for(int start=str.length-2; start>=0; start--) {
            for (int end=start+1; end<str.length; end++) {
                if(str[start] == str[end]) {
                    table[start][end] = 2 + table[start+1][end-1];
                } else {
                    table[start][end] = Math.max(table[start+1][end],table[start][end-1]);
                }                
            }
        }
        return table[0][str.length-1];
    }
    
}
