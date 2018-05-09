package com.chrisleung.leetcode.solutions;

public class Problem_091_Decode_Ways_Iterative {
    public int numDecodings(String s) {
        if(s == null || s.isEmpty()) return 0;
        char[] str = s.toCharArray();
        int[] table = new int[str.length+1];
        table[str.length] = 1;
        for(int i=str.length-1; i>=0; i--) {
            if(str[i] == '0') continue;
            int ways = table[i+1];
            if(i < str.length-1 && (str[i] == '1' || (str[i] == '2' && str[i+1] >= '0' && str[i+1] <= '6'))) {
                ways += table[i+2];
            }  
            table[i] = ways;            
        }
        return table[0];
    }
}
