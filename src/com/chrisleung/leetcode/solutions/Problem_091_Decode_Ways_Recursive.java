package com.chrisleung.leetcode.solutions;

public class Problem_091_Decode_Ways_Recursive {
    public int numDecodings(String s) {
        if(s == null || s.isEmpty()) return 0;
        Integer[] memo = new Integer[s.length()];
        return numWays(s.toCharArray(),0,memo);
    }
    
    private int numWays(char[] str, int i, Integer[] memo) {
        if(i == str.length) return 1;
        if(str[i] == '0') return 0;
        if(memo[i] == null) {
            int ways = numWays(str,i+1,memo);
            if(i < str.length-1 && (str[i] == '1' || (str[i] == '2' && str[i+1] >= '0' && str[i+1] <= '6'))) {
                ways += numWays(str,i+2,memo);
            }  
            memo[i] = ways;
        }
        return memo[i];
    }
}
