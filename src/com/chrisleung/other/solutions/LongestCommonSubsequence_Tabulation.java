package com.chrisleung.other.solutions;

public class LongestCommonSubsequence_Tabulation {
    
    public static int longest(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int[][] table = new int[s1.length+1][s2.length+1];
        for(int i=s1.length-1; i>=0; i--) {
            for(int j=s2.length-1; j>=0; j--) {
                int longest = 0;
                if(s1[i] == s2[j]) {            
                    longest = 1 + table[i+1][j+1];
                } else {
                    longest = Math.max(table[i+1][j], table[i][j+1]);
                }
                table[i][j] = longest;
            }
        }
        return table[0][0];
    }
    
    public static void main (String[] args) {
        //String str1 = "ABCDGH";
        //String str2 = "AEDFHR";
        //String s1 = "AGGTAB";
        //String s2 = "GXTXAYB";
        String s1 = "11111111abcd";
        String s2 = "abcd22222222";
        System.out.println(longest(s1,s2));
    }
}
