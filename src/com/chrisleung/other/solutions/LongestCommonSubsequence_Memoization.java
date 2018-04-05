package com.chrisleung.other.solutions;

import java.util.Arrays;

public class LongestCommonSubsequence_Memoization {
    
    public static int longest(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        Integer[][] memo = new Integer[s1.length][s2.length];
        int result = helper(0,0,s1,s2,memo);
        System.out.println(Arrays.deepToString(memo));
        return result;
        // Inputs: Index of character in each string
        // If the characters are the same, then increment the longest common subsequence so far by 1
        // If not the same, then take the max of the longest common subsequence if we skip a character in str1 vs character in string 2
        // Outputs: Longest common subsequence found in the two strings
        // Base case: One or both strings are empty (return 0)
    }
    private static int helper(int i, int j, char[] s1, char[] s2, Integer[][] memo) {
        if(i == s1.length || j == s2.length) return 0;
        if(memo[i][j] == null) {
            int longest = 0;
            if(s1[i] == s2[j]) {            
                longest = 1 + helper(i+1,j+1,s1,s2,memo);
            } else {
                longest = Math.max(helper(i+1,j,s1,s2,memo), helper(i,j+1,s1,s2,memo));
            }
            memo[i][j] = longest;
        }
        return memo[i][j];
    }
    
    public static void main (String[] args) {
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        System.out.println(longest(str1,str2));
    }
}
