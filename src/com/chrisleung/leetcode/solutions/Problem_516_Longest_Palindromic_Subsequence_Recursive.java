package com.chrisleung.leetcode.solutions;

public class Problem_516_Longest_Palindromic_Subsequence_Recursive {
    
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.isEmpty()) return 0;
        return longestFrom(0,s.length()-1,s,new Integer[s.length()][s.length()]);
    }
    
    private int longestFrom(int start, int end, String s, Integer[][] memo) {
        if(start > end) return 0;
        if(start == end) return 1;
        if(memo[start][end] == null) {
            if(s.charAt(start) == s.charAt(end)) {
                memo[start][end] = 2 + longestFrom(start+1,end-1,s,memo);
            } else {
                memo[start][end] = Math.max(longestFrom(start+1,end,s,memo),longestFrom(start,end-1,s,memo));
            }
        }
        return memo[start][end];
    }
    
}
